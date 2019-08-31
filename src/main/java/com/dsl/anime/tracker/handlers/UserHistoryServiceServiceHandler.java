package com.dsl.anime.tracker.handlers;

import com.dsl.anime.tracker.rest.dto.UserHistoryDetails;
import com.dsl.anime.tracker.services.UserHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserHistoryServiceServiceHandler implements UserHistoryService
{
    public List<UserHistoryDetails> list()
    {
        return null;
    }

    public List<UserHistoryDetails> search(Long id)
    {
        return null;
    }

    public void create(UserHistoryDetails userHistoryDetails)
    {

    }

    public void update(UserHistoryDetails userHistoryDetails)
    {

    }

    public void delete(Long id)
    {

    }
}
