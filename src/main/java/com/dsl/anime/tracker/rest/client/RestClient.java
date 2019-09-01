package com.dsl.anime.tracker.rest.client;

import com.dsl.anime.tracker.exceptions.dto.Violation;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

@Component
public class RestClient
{
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

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
        try
        {
            ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(object), clazz);
            return response.getBody();
        }
        catch (HttpClientErrorException e)
        {
            handleClientErrorException(e);
        }
        return null;
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

    private void handleClientErrorException(HttpClientErrorException e)
    {
        switch (e.getStatusCode())
        {
            case BAD_REQUEST:
                List<Violation> violations = convert(e.getResponseBodyAsString());
                violations.forEach(violation -> System.out.println("field=" + violation.getField() + " errors=" + violation.getErrors()));
                break;
            case NOT_FOUND:
                System.out.println("Handled not found exception");
                break;
            default:
                break;
        }
    }

    private List<Violation> convert(String responseBody)
    {
        try
        {
            JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, Violation.class);
            return objectMapper.readValue(responseBody, type);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
