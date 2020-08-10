package com.ph.remote.service;

import com.ph.remote.entity.Players;

import java.util.Collection;
import java.util.List;

public interface PlayerService {
    List<Players> findAll();

    Players findByTag(String tag);

    void saveAndUpdatePlayers(Players players);

    List<Players> findByClanTagIgnoreSome(String tag, Collection<String> exceps);

    List<Players> findByClanTag(String tag);

    void deleteByPlayerTag(String tag);
}
