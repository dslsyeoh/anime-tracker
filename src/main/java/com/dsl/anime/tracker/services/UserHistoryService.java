/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.anime.tracker.services;

import com.dsl.anime.tracker.rest.dto.UserHistoryDetails;

import java.util.List;

public interface UserHistoryService
{
    List<UserHistoryDetails> list();

    List<UserHistoryDetails> search(Long id);

    void create(UserHistoryDetails userHistoryDetails);

    void update(UserHistoryDetails userHistoryDetails);

    void delete(Long id);
}
