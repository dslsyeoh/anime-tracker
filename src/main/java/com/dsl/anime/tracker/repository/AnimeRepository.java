/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved
 */

package com.dsl.anime.tracker.repository;

import com.dsl.anime.tracker.entity.AnimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnimeRepository extends JpaRepository<AnimeEntity, Long>
{
    Optional<AnimeEntity> findByName(String name);
}
