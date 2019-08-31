package com.dsl.anime.tracker.rest.utils;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public final class Builder
{
    private Builder() {}

    public static <T> String build(String url, T id)
    {
        return UriComponentsBuilder.fromUriString(url).build(id).toString();
    }
}
