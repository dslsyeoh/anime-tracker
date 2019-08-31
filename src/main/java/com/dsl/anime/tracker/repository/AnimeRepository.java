package com.dsl.anime.tracker.repository;

import com.dsl.anime.tracker.entity.AnimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends JpaRepository<AnimeEntity, Long>
{
}
