/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved
 */

package com.dsl.anime.tracker.rest.managers;

import com.dsl.anime.tracker.rest.client.RestClient;
import com.dsl.anime.tracker.rest.dto.Anime;
import com.dsl.anime.tracker.rest.utils.UrlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnimeManager
{
    @Autowired
    private RestClient restClient;

    private static final String BASE_URL = "api/anime";

    public List<Anime> list()
    {
        return restClient.getObjects(BASE_URL, Anime[].class);
    }

    public Anime search(Long id)
    {
        String url = UrlBuilder.build(BASE_URL, id);
        return restClient.getObject(url, Anime.class);
    }

    public Anime create(Anime anime)
    {
        return restClient.postObject(BASE_URL, anime, Anime.class);
    }

    public Anime update(Anime anime)
    {
        return restClient.putObject(BASE_URL, anime, Anime.class);
    }

    public void delete(Long id)
    {
        String url = UrlBuilder.build(BASE_URL, id);
        restClient.deleteObject(url, Anime.class);
    }
}
