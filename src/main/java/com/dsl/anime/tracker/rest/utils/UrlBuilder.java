package com.dsl.anime.tracker.rest.utils;

import org.springframework.web.util.UriComponentsBuilder;

public final class UrlBuilder
{
    private UrlBuilder() {}

    public static <T> String build(String url, T id)
    {
        return UriComponentsBuilder.fromUriString(url).build(id).toString();
    }
}
