package com.ph.remote.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity(name = "tb_players")
@DynamicInsert
@DynamicUpdate
public class Players {

    //玩家标签
    @Id
    private String tag;

    //玩家昵称
    private String name;

    //大本营基本
    private Integer townHallLevel;

    //大本营是几星的
    private Integer townHallWeaponLevel;

    //经验等级
    private Integer expLevel;

    //杯数
    private Integer trophies;

    //部落战胜利之星
    private Integer warStars;

    //攻击获胜次数
    private Integer attackWins;

    //防御获胜次数
    private Integer defenseWins;

    //夜世界杯
    private Integer builderHallLevel;

    //夜世界杯
    private Integer versusTrophies;

    //职位
    private String role;

    //捐赠数
    private Integer donations;

    //收兵数
    private Integer donationsReceived;

    //活跃度
    private Integer activeRank;

    //信息更新时间

    private Date updateTime;

    private String clanTag;


    private Date createTime;
}

