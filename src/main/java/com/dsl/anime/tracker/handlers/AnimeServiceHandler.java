/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.anime.tracker.handlers;

import com.dsl.anime.tracker.entity.AnimeEntity;
import com.dsl.anime.tracker.exceptions.BadRequestException;
import com.dsl.anime.tracker.exceptions.NotFoundException;
import com.dsl.anime.tracker.mapper.AnimeMapper;
import com.dsl.anime.tracker.repository.AnimeRepository;
import com.dsl.anime.tracker.rest.dto.Anime;
import com.dsl.anime.tracker.services.AnimeService;
import com.dsl.anime.tracker.validations.CreateValidation;
import com.dsl.anime.tracker.validations.UpdateValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class AnimeServiceHandler implements AnimeService
{
    @Autowired
    private AnimeRepository animeRepository;

    @Autowired
    private Validator validator;

    @Autowired
    private AnimeMapper animeMapper;

    public List<Anime> list()
    {
        return animeRepository.findAll().stream().map(animeMapper::convert).collect(Collectors.toList());
    }

    public Anime search(Long id)
    {
        AnimeEntity entity = animeRepository.findById(id).orElseThrow(NotFoundException::new);
        return animeMapper.convert(entity);
    }

    public Anime create(Anime anime)
    {
        Set<ConstraintViolation<Anime>> errors = validator.validate(anime, CreateValidation.class);
        if(!errors.isEmpty()) throw new BadRequestException(errors);
        AnimeEntity entity = animeMapper.toEntity(anime);

        AnimeEntity created = animeRepository.save(entity);
        return animeMapper.convert(created);
    }

    public Anime update(Anime anime)
    {
        if(!animeRepository.existsById(anime.getId())) throw new NotFoundException();
        Set<ConstraintViolation<Anime>> errors = validator.validate(anime, UpdateValidation.class);
        if(!errors.isEmpty()) throw new BadRequestException(errors);
        AnimeEntity toBeUpdated = animeMapper.toEntity(anime);

        AnimeEntity updated = animeRepository.save(toBeUpdated);

        return animeMapper.convert(updated);
    }

    public void delete(Long id)
    {
        AnimeEntity toBeDeleted = animeRepository.findById(id).orElseThrow(NotFoundException::new);
        animeRepository.delete(toBeDeleted);
    }
}
