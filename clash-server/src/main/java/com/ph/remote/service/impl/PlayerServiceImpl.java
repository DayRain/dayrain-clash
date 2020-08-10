package com.ph.remote.service.impl;

import com.ph.remote.entity.Players;
import com.ph.remote.repository.PlayerRepository;
import com.ph.remote.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.UriEncoder;

import java.util.Collection;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public List<Players> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public Players findByTag(String tag) {
        tag = UriEncoder.decode(tag);
        return playerRepository.findByTag(tag);
    }

    @Override
    public void saveAndUpdatePlayers(Players players) {
         playerRepository.saveAndFlush(players);
    }

    @Override
    public List<Players> findByClanTagIgnoreSome(String clanTag, Collection<String> exceps) {

        return playerRepository.findByClanTagAndTagNotInOrderByActiveRankDesc(clanTag, exceps);
    }

    @Override
    public List<Players> findByClanTag(String tag) {
        return playerRepository.findByClanTag(tag);
    }

    @Override
    public void deleteByPlayerTag(String tag) {
        playerRepository.deleteById(tag);
    }
}
