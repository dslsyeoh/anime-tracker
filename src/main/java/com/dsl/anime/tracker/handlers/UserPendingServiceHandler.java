package com.dsl.anime.tracker.handlers;

import com.dsl.anime.tracker.rest.dto.UserPendingDetails;
import com.dsl.anime.tracker.services.UserPendingService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserPendingServiceHandler implements UserPendingService
{
    public List<UserPendingDetails> list()
    {
        return null;
    }

    public List<UserPendingDetails> search(Long id)
    {
        return null;
    }

    public void create(UserPendingDetails userPendingDetails)
    {

    }

    public void update(UserPendingDetails userPendingDetails)
    {

    }

    public void delete(Long id)
    {

    }
}
