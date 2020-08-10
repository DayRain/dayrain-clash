package com.ph.remote.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ph.remote.entity.Clan;
import com.ph.remote.entity.Players;
import com.ph.remote.entity.StayRecord;
import com.ph.remote.service.ClanService;
import com.ph.remote.service.PlayerService;
import com.ph.remote.service.StayRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Component
public class TimeSchedule {

    @Autowired
    ClanService clanService;

    @Autowired
    PlayerService playerService;

    @Autowired
    StayRecordService stayRecordService;


    @Autowired
    DataApi dataApi;

    //十分钟采集一次
    @Scheduled(fixedRate = 600000)
    public void getData() throws JsonProcessingException {
        String decodeTag = "#22G8Q2GJV";
        Clan clanData = dataApi.getClanData(decodeTag);
        List<Players> memberList = clanData.getMemberList();
        //更新部落信息以及部落成员信息
        loadClanPlayersData(decodeTag , memberList, clanData);
        //更新一条记录
        updatePlayersRecord(decodeTag, memberList);
    }

    //添加记录，并从主列表中删除已离开的
    private void updatePlayersRecord(String decodeTag, List<Players> memberList) {
        HashSet<String> playerSet  =new HashSet<>();
        for (Players players : memberList) {
            playerSet.add(players.getTag());
            if (stayRecordService.findByPlayerTagAndClanTag(players.getTag(), decodeTag) == null) {
                StayRecord stayRecord = new StayRecord();
                stayRecord.setClanTag(decodeTag);
                stayRecord.setJoinTime(new Date());
                stayRecord.setPlayTag(players.getTag());
                stayRecordService.save(stayRecord);
            }
        }

        //删除已离开的用户
        List<Players> beforeMemberList = playerService.findByClanTag(decodeTag);
        for (Players players : beforeMemberList) {
            if(!playerSet.contains(players.getTag())){
                playerService.deleteByPlayerTag(players.getTag());
            }
        }
    }


    private void loadClanPlayersData(String tag, List<Players>memberList, Clan clanData) throws JsonProcessingException {

        if(clanData != null && clanData.getTag() != null){
            System.out.println(clanData);
            clanService.saveAndUpdateClan(clanData);

            for (Players players : memberList) {
                Players playerData = dataApi.getPlayerData(players.getTag());
                Date date = new Date();
                playerData.setUpdateTime(date);

                playerData.setClanTag(tag);
                playerService.saveAndUpdatePlayers(playerData);
            }
        }else{
            System.out.println("no data get from server______________");
        }
    }
}
