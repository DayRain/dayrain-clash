package com.ph.remote.service.impl;

import com.ph.remote.entity.StayRecord;
import com.ph.remote.repository.StayRecordRepository;
import com.ph.remote.service.PlayerService;
import com.ph.remote.service.StayRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StayRecordServiceImpl implements StayRecordService {

    @Autowired
    StayRecordRepository stayRecordRepository;

    @Override
    public StayRecord findByPlayerTagAndClanTag(String playerTag, String decodeTag) {
        return stayRecordRepository.findByPlayTagAndClanTag(playerTag, decodeTag);
    }

    @Override
    public StayRecord save(StayRecord stayRecord) {
        return stayRecordRepository.save(stayRecord);
    }
}
