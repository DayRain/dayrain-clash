package com.ph.remote.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class StayRecord {

    @Id
    @GeneratedValue
    private Long id;

    private String playTag;

    private String clanTag;

    private Date joinTime;
}
