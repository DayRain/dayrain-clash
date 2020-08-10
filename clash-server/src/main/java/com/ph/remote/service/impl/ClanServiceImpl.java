package com.ph.remote.service.impl;

import com.ph.remote.entity.Clan;
import com.ph.remote.repository.ClanRepository;
import com.ph.remote.service.ClanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClanServiceImpl implements ClanService {

    @Autowired
    ClanRepository clanRepository;

    @Override
    public Clan findByTag(String tag) {
        return clanRepository.findByTag(tag);
    }

    @Override
    public void saveAndUpdateClan(Clan clan) {
        clanRepository.saveAndFlush(clan);
    }
}
