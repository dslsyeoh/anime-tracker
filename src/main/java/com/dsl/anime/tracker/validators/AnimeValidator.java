/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.anime.tracker.validators;

import com.dsl.anime.tracker.constraints.Anime;
import com.dsl.anime.tracker.entity.AnimeEntity;
import com.dsl.anime.tracker.repository.AnimeRepository;
import com.dsl.anime.tracker.rest.dto.AnimeDetails;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;
import java.util.Optional;

public class AnimeValidator implements ConstraintValidator<Anime, AnimeDetails>
{
    @Autowired
    private AnimeRepository animeRepository;

    @Override
    public boolean isValid(AnimeDetails animeDetails, ConstraintValidatorContext constraintValidatorContext)
    {
        boolean isValid;
        if(Objects.nonNull(animeDetails.getId()))
        {
            Optional<AnimeEntity> entity = animeRepository.findByName(animeDetails.getName());
            isValid = !entity.isPresent() || Objects.equals(entity.get().getId(), animeDetails.getId());
        }
        else
        {
            isValid = !animeRepository.findByName(animeDetails.getName()).isPresent();
        }

        if(!isValid)
        {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(constraintValidatorContext.getDefaultConstraintMessageTemplate()).addPropertyNode("name").addConstraintViolation();
            return false;
        }
        return true;
    }
}
