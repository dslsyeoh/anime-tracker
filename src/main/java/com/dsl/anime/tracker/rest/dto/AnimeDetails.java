package com.dsl.anime.tracker.rest.dto;

import com.dsl.anime.tracker.mapper.AbstractMapper;
import lombok.Data;

import java.util.Date;

@Data
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
