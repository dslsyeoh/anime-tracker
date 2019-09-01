/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.anime.tracker.rest.dto;

import com.dsl.anime.tracker.constraints.Anime;
import com.dsl.anime.tracker.validations.CreateValidation;
import com.dsl.anime.tracker.validations.UpdateValidation;
import lombok.Data;

import java.util.Date;

@Data
@Anime(groups = {CreateValidation.class, UpdateValidation.class})
public class AnimeDetails
{
    private Long id;
    private String name;
    private Date releaseDate;
    private Date nextRenewDate;
    private int renewDays;
    private int currentEpisode;
    private int rating;
    private String summary;
    private boolean onAir;
}
