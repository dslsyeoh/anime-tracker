/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.anime.tracker.repository;

import com.dsl.anime.tracker.entity.UserPendingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPendingRepository extends JpaRepository<UserPendingEntity, Long>
{
}
