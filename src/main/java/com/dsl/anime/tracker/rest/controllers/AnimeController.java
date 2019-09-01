/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.anime.tracker.rest.controllers;

import com.dsl.anime.tracker.rest.dto.AnimeDetails;
import com.dsl.anime.tracker.services.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/anime")
public class AnimeController
{
    @Autowired
    private AnimeService animeService;

    @GetMapping
    private List<AnimeDetails> list()
    {
        return animeService.list();
    }

    @GetMapping("/{id}")
    private AnimeDetails search(@PathVariable Long id) { return animeService.search(id); }

    @PostMapping
    private AnimeDetails create(@RequestBody AnimeDetails animeDetails)
    {
        return animeService.create(animeDetails);
    }

    @PutMapping
    private AnimeDetails update(@RequestBody AnimeDetails animeDetails) { return animeService.update(animeDetails); }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable Long id) { animeService.delete(id); }
}
