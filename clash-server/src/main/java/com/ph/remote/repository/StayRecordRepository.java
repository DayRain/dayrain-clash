package com.ph.remote.repository;

import com.ph.remote.entity.Players;
import com.ph.remote.entity.StayRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StayRecordRepository extends JpaRepository<StayRecord, String> {
    StayRecord findByPlayTagAndClanTag(String playTag, String clanTag);
}
