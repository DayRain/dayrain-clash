package com.ph.remote.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ph.remote.entity.Clan;
import com.ph.remote.entity.Players;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.util.UriEncoder;

import java.util.List;

@Component
public class DataApi {

    @Autowired
    HttpUtils httpUtils;

    //通过用户标签获取用户详细信息
    public Players getPlayerData(String clanTag) throws JsonProcessingException {
        String s = httpUtils.get("https://api.clashofclans.com/v1/players/"+stringCheck(clanTag));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Players players = objectMapper.readValue(s, Players.class);
        players.setActiveRank((int)(players.getAttackWins()*0.8) + (int)(players.getDonations()*0.03) + (int)(players.getDonationsReceived()*0.005));
        return players;
    }

    public Clan getClanData(String clanTag) throws JsonProcessingException {

        String s = httpUtils.get("https://api.clashofclans.com/v1/clans/"+stringCheck(clanTag));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Clan clan = objectMapper.readValue(s, Clan.class);
        List<Players> memberList = clan.getMemberList();
        clan.getMemberList().set(0, getPlayerData(memberList.get(0).getTag()));
        clan.setMemberList(memberList);
        return clan;
    }

    private String stringCheck(String clanTag){
        if(clanTag.startsWith("#")){
            clanTag = UriEncoder.encode(clanTag);
        }
        return clanTag;
    }
}
