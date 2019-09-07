/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.anime.tracker.handlers;

import com.dsl.anime.tracker.rest.dto.UserHistory;
import com.dsl.anime.tracker.services.UserHistoryService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserHistoryServiceServiceHandler implements UserHistoryService
{
    public List<UserHistory> list()
    {
        return null;
    }

    public List<UserHistory> search(Long id)
    {
        return null;
    }

    public void create(UserHistory userHistory)
    {

    }

    public void update(UserHistory userHistory)
    {

    }

    public void delete(Long id)
    {

    }
}
