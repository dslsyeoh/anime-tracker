/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved
 */

package com.dsl.anime.tracker.services;

import com.dsl.anime.tracker.rest.dto.UserHistory;

import java.util.List;

public interface UserHistoryService
{
    List<UserHistory> list();

    List<UserHistory> search(Long id);

    void create(UserHistory userHistory);

    void update(UserHistory userHistory);

    void delete(Long id);
}
