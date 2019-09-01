/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.anime.tracker.rest.dto;

import lombok.Data;

@Data
public class UserRecommendationDetails
{
    private String animeName;
    private String comment;
    private int rating;
}
