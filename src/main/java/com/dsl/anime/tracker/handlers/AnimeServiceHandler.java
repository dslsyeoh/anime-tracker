package com.dsl.anime.tracker.handlers;

import com.dsl.anime.tracker.entity.AnimeEntity;
import com.dsl.anime.tracker.exceptions.BadRequestException;
import com.dsl.anime.tracker.exceptions.NotFoundException;
import com.dsl.anime.tracker.mapper.AbstractMapper;
import com.dsl.anime.tracker.repository.AnimeRepository;
import com.dsl.anime.tracker.rest.dto.AnimeDetails;
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
public class AnimeServiceHandler extends AbstractMapper implements AnimeService
{
    @Autowired
    private AnimeRepository animeRepository;

    @Autowired
    private Validator validator;

    public List<AnimeDetails> list()
    {
        List<AnimeEntity> entities = animeRepository.findAll();
        if(entities.isEmpty()) return Collections.emptyList();
        return entities.stream().map(entity -> toMap(entity, AnimeDetails.class)).collect(Collectors.toList());
    }

    public AnimeDetails search(Long id)
    {
        AnimeEntity entity = animeRepository.findById(id).orElseThrow(NotFoundException::new);
        return toMap(entity, AnimeDetails.class);
    }

    public AnimeDetails create(AnimeDetails animeDetails)
    {
        Set<ConstraintViolation<AnimeDetails>> errors = validator.validate(animeDetails, CreateValidation.class);
        if(!errors.isEmpty()) throw new BadRequestException(errors);
        AnimeEntity entity = toEntity(animeDetails);

        AnimeEntity created = animeRepository.save(entity);
        return toMap(created, AnimeDetails.class);
    }

    public AnimeDetails update(AnimeDetails animeDetails)
    {
        AnimeEntity entity = animeRepository.findById(animeDetails.getId()).orElseThrow(NotFoundException::new);
        Set<ConstraintViolation<AnimeDetails>> errors = validator.validate(animeDetails, UpdateValidation.class);
        if(!errors.isEmpty()) throw new BadRequestException(errors);
        AnimeEntity toBeUpdated = toEntity(animeDetails, entity);

        AnimeEntity updated = animeRepository.save(toBeUpdated);

        return toMap(updated, AnimeDetails.class);
    }

    public void delete(Long id)
    {
        AnimeEntity toBeDeleted = animeRepository.findById(id).orElseThrow(NotFoundException::new);
        animeRepository.delete(toBeDeleted);
    }

    private AnimeEntity toEntity(AnimeDetails animeDetails)
    {
        return toEntity(animeDetails, new AnimeEntity());
    }

    private AnimeEntity toEntity(AnimeDetails animeDetails, AnimeEntity entity)
    {
        entity.setName(animeDetails.getName());
        entity.setOnAir(animeDetails.isOnAir());
        entity.setRating(animeDetails.getRating());
        entity.setSummary(animeDetails.getSummary());
        entity.setRenewDays(animeDetails.getRenewDays());
        entity.setReleaseDate(animeDetails.getReleaseDate());
        entity.setNextRenewDate(animeDetails.getNextRenewDate());
        entity.setCurrentEpisode(animeDetails.getCurrentEpisode());

        return entity;
    }
}
