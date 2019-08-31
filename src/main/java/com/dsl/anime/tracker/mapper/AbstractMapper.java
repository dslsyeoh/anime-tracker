package com.dsl.anime.tracker.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractMapper
{
    @Autowired
    private ObjectMapper objectMapper;

    public <S, T> T toMap(S obj, Class<T> type)
    {
        return objectMapper.convertValue(obj, type);
    }
}
