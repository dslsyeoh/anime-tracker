package com.dsl.anime.tracker.services;

import com.dsl.anime.tracker.rest.dto.AnimeDetails;

import java.util.List;

public interface AnimeService
{
    List<AnimeDetails> list();

    AnimeDetails search(Long id);

    AnimeDetails create(AnimeDetails animeDetails);

    AnimeDetails update(AnimeDetails animeDetails);

    void delete(Long id);
}
