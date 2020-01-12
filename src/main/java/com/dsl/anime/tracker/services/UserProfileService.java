/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved
 */

package com.dsl.anime.tracker.services;

import com.dsl.anime.tracker.rest.dto.UserProfileDetails;

public interface UserProfileService
{
    void update(UserProfileDetails userProfileDetails);
}
