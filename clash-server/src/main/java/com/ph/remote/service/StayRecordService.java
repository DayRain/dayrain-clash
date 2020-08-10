package com.ph.remote.service;

import com.ph.remote.entity.StayRecord;

public interface StayRecordService {
    StayRecord findByPlayerTagAndClanTag(String playerTag, String decodeTag);

    StayRecord save(StayRecord stayRecord);
}
