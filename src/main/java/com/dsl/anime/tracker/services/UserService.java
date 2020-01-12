/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved
 */

package com.dsl.anime.tracker.services;

import com.dsl.anime.tracker.rest.dto.User;

import java.util.List;

public interface UserService
{
    List<User> list();

    User create(User user);

    User update(User user);

    void delete(Long id);
}
