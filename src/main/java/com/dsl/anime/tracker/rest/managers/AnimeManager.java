package com.dsl.anime.tracker.rest.managers;

import com.dsl.anime.tracker.rest.client.RestClient;
import com.dsl.anime.tracker.rest.dto.AnimeDetails;
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

    public List<AnimeDetails> list()
    {
        return restClient.getObjects(BASE_URL, AnimeDetails[].class);
    }

    public AnimeDetails search(Long id)
    {
        String url = UrlBuilder.build(BASE_URL, id);
        return restClient.getObject(url, AnimeDetails.class);
    }

    public AnimeDetails create(AnimeDetails animeDetails)
    {
        return restClient.postObject(BASE_URL, animeDetails, AnimeDetails.class);
    }

    public AnimeDetails update(AnimeDetails animeDetails)
    {
        return restClient.putObject(BASE_URL, animeDetails, AnimeDetails.class);
    }

    public void delete(Long id)
    {
        String url = UrlBuilder.build(BASE_URL, id);
        restClient.deleteObject(url, AnimeDetails.class);
    }
}
