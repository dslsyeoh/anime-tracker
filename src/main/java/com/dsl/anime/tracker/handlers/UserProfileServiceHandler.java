/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved
 */

package com.dsl.anime.tracker.handlers;

import com.dsl.anime.tracker.rest.dto.UserProfileDetails;
import com.dsl.anime.tracker.services.UserProfileService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserProfileServiceHandler implements UserProfileService
{
    public void update(UserProfileDetails userProfileDetails)
    {

    }
}
