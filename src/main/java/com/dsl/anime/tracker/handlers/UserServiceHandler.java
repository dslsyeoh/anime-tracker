/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.anime.tracker.handlers;

import com.dsl.anime.tracker.rest.dto.UserDetails;
import com.dsl.anime.tracker.services.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceHandler implements UserService
{
    public List<UserDetails> list()
    {
        return null;
    }

    public void create(UserDetails userDetails)
    {

    }

    public void update(UserDetails userDetails)
    {

    }

    public void delete(Long id)
    {

    }
}
