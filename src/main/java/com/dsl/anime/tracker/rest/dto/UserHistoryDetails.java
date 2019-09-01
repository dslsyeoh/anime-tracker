/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.anime.tracker.rest.dto;

import lombok.Data;

@Data
public class UserHistoryDetails
{
    private String animeName;
    private int currentEpisode;
}
