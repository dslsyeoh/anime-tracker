/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved
 */

package com.dsl.anime.tracker.services;

import com.dsl.anime.tracker.rest.dto.Anime;

import java.util.List;

public interface AnimeService
{
    List<Anime> list();

    Anime search(Long id);

    Anime create(Anime anime);

    Anime update(Anime anime);

    void delete(Long id);
}
