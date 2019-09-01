/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.anime.tracker.rest.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserProfileDetails
{
    private String name;
    private String password;
    private String bio;
    private int contributionLevel;
    private List<UserRecommendationDetails> userRecommendationDetails;
}
