package com.dsl.anime.tracker.repository;

import com.dsl.anime.tracker.entity.UserEntity;
import com.dsl.anime.tracker.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long>
{
}
