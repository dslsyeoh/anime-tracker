/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.anime.tracker.mapper;

import com.dsl.anime.tracker.entity.UserEntity;
import com.dsl.anime.tracker.rest.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends AbstractMapper<UserEntity, User>
{
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserEntity toEntity(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return toEntity(user, UserEntity.class);
    }

    @Override
    public User convert(UserEntity entity)
    {
        User user = new User();
        user.setId(entity.getId());
        user.setUsername(entity.getUsername());
        user.setPassword(passwordEncoder.encode(entity.getPassword()));

        return user;
    }
}
