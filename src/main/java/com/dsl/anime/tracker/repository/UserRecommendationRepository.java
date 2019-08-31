package com.dsl.anime.tracker.repository;

import com.dsl.anime.tracker.entity.UserRecommendationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRecommendationRepository extends JpaRepository<UserRecommendationEntity, Long>
{
}
