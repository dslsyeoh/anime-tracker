/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved
 */

package com.dsl.anime.tracker.services;

import com.dsl.anime.tracker.rest.dto.UserRoleDetails;

import java.util.List;

public interface UserRoleService
{
    List<UserRoleDetails> list();

    void create(UserRoleDetails userDetails);

    void update(UserRoleDetails userDetails);

    void delete(Long id);
}
