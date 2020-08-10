package com.ph.remote.repository;

import com.ph.remote.entity.Clan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClanRepository extends JpaRepository<Clan, String> {
    Clan findByTag(String tag);
}
