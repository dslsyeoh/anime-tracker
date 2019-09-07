/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.anime.tracker.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractMapper<E, T>
{
    @Autowired
    private ObjectMapper objectMapper;

    E toEntity(T object, Class<E> clazz)
    {
        return objectMapper.convertValue(object, clazz);
    }

    public abstract T convert(E entity);
}
