/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.anime.tracker.rest.controllers;

import com.dsl.anime.tracker.rest.dto.Anime;
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
    private List<Anime> list()
    {
        return animeService.list();
    }

    @GetMapping("/{id}")
    private Anime search(@PathVariable Long id) { return animeService.search(id); }

    @PostMapping
    private Anime create(@RequestBody Anime anime)
    {
        return animeService.create(anime);
    }

    @PutMapping
    private Anime update(@RequestBody Anime anime) { return animeService.update(anime); }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable Long id) { animeService.delete(id); }
}
