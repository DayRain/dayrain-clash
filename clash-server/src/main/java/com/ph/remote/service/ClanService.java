package com.ph.remote.service;

import com.ph.remote.entity.Clan;

public interface ClanService {
    Clan findByTag(String tag);

    void saveAndUpdateClan(Clan clan);

}
