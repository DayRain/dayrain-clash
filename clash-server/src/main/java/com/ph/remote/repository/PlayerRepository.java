package com.ph.remote.repository;

import com.ph.remote.entity.Players;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface PlayerRepository extends JpaRepository<Players, String> {
    Players findByTag(String tag);

    List<Players> findByClanTagOrderByActiveRankDesc(String clanTag);

    List<Players> findByClanTagAndTagNotInOrderByActiveRankDesc(String clanTag, Collection<String> tag);

    List<Players> findByClanTag(String clanTag);

}
