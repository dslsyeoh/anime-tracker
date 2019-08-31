package com.dsl.anime.tracker.rest.client;

import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
public class RestClient
{
    @Autowired
    private RestTemplate restTemplate;

    public <T> T getObject(String url, Class<T> clazz)
    {
        return restTemplate.getForObject(url, clazz);
    }

    public <T> List<T> getObjects(String url, Class<T[]> clazz)
    {
        ResponseEntity<T[]> response = restTemplate.exchange(url, HttpMethod.GET, null, ParameterizedTypeReference.forType(clazz));
        return Optional.ofNullable(response.getBody()).map(Arrays::asList).orElseGet(ArrayList::new);
    }

    public <T> T postObject(String url, T object, Class<T> clazz)
    {
        ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(object), clazz);
        return response.getBody();
    }

    public <T> List<T> postObjects(String url, List<T> object, Class<T[]> clazz)
    {
        ResponseEntity<T[]> response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(object), ParameterizedTypeReference.forType(clazz));
        return Optional.ofNullable(response.getBody()).map(Arrays::asList).orElseGet(ArrayList::new);
    }

    public <T> T putObject(String url, T object, Class<T> clazz)
    {
        ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<>(object), ParameterizedTypeReference.forType(clazz));
        return response.getBody();
    }

    public <T> void deleteObject(String url, Class<T> clazz)
    {
        restTemplate.exchange(url, HttpMethod.DELETE, null, ParameterizedTypeReference.forType(clazz));
    }
}
