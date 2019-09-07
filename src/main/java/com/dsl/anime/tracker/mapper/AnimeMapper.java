/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.anime.tracker.mapper;

import com.dsl.anime.tracker.entity.AnimeEntity;
import com.dsl.anime.tracker.rest.dto.Anime;
import org.springframework.stereotype.Component;

@Component
public class AnimeMapper extends AbstractMapper<AnimeEntity, Anime>
{
    public AnimeEntity toEntity(Anime object)
    {
        return toEntity(object, AnimeEntity.class);
    }

    @Override
    public Anime convert(AnimeEntity entity)
    {
        Anime anime = new Anime();
        anime.setId(entity.getId());
        anime.setName(entity.getName());
        anime.setOnAir(entity.isOnAir());
        anime.setRating(entity.getRating());
        anime.setSummary(entity.getSummary());
        anime.setRenewDays(entity.getRenewDays());
        anime.setReleaseDate(entity.getReleaseDate());
        anime.setNextRenewDate(entity.getNextRenewDate());
        anime.setCurrentEpisode(entity.getCurrentEpisode());

        return anime;
    }
}
