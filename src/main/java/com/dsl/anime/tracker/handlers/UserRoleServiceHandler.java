package com.dsl.anime.tracker.handlers;

import com.dsl.anime.tracker.rest.dto.UserRoleDetails;
import com.dsl.anime.tracker.services.UserRoleService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserRoleServiceHandler implements UserRoleService
{
    public List<UserRoleDetails> list()
    {
        return null;
    }

    public void create(UserRoleDetails userDetails)
    {

    }

    public void update(UserRoleDetails userDetails)
    {

    }

    public void delete(Long id)
    {

    }
}
