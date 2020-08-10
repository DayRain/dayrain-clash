package com.ph.remote.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

//部落
@Data
@Entity(name = "tb_clan")
public class Clan {

    //标签
    @Id
    private String tag;

    //部落名
    private String name;

    //类型：是否可加入
    private String type;

    //描述
    private String description;

    //图标

    @Transient
    private BadgeUrls badgeUrls;

    //部落等级
    private String clanLevel;

    //主世界积分
    private String clanPoints;

    //夜世界积分
    private String clanVersusPoints;

    //所需奖杯
    private Integer requiredTrophies;

    //战争平路
    private String warFrequency;

    //部落站连胜数
    private Integer warWinStreak;

    //部落站获胜次数
    private Integer warWins;

    //当前成员总数
    private Integer members;

    @Transient
    private List<Players>memberList;

}
