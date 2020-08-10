package com.ph.remote.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ph.remote.dto.CommonReturn;
import com.ph.remote.entity.Clan;
import com.ph.remote.entity.Players;
import com.ph.remote.service.ClanService;
import com.ph.remote.service.PlayerService;
import com.ph.remote.util.DataApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class CommonController {

    @Autowired
    DataApi dataApi;

    @Autowired
    PlayerService playerService;

    @Autowired
    ClanService clanService;

    //获取某个玩家的详细信息
    @RequestMapping("/")
    public String hello()  {


        return "hello";
    }



    //获取某个玩家的详细信息
    @RequestMapping("/player/{tag}")
    public CommonReturn getPlayers(@PathVariable String tag) throws JsonProcessingException {
        CommonReturn commonReturn = new CommonReturn();
        Players players = playerService.findByTag(tag);
        if(players.getTag() == null)
            commonReturn.fail("没有该玩家");
        else{
            commonReturn.success(players);
        }
        return commonReturn;
    }

    @RequestMapping("/clans/{tag}")
    public CommonReturn getClans(@PathVariable String tag) {
        CommonReturn commonReturn = new CommonReturn();
        Clan clan = clanService.findByTag(tag);
        if(clan.getTag() == null)
            commonReturn.fail("没有该部落");
        else{
            commonReturn.success(clan);
        }

        return commonReturn;
    }

    //某个部落所有玩家的信息
    @RequestMapping("/clans/players/{tag}")
    public CommonReturn getPlayersByActive(@PathVariable String tag){
        CommonReturn commonReturn = new CommonReturn();
        List<Players> playersList = playerService.findByClanTagIgnoreSome(tag, Collections.singleton("#Y0LQPQU99"));
        if(playersList == null)
            commonReturn.fail("没有该部落");
        else{
            commonReturn.success(playersList);
        }
        return commonReturn;
    }

}
