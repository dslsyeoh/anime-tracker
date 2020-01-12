/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved
 */

package com.dsl.anime.tracker.validators;

import com.dsl.anime.tracker.constraints.AnimeName;
import com.dsl.anime.tracker.entity.AnimeEntity;
import com.dsl.anime.tracker.repository.AnimeRepository;
import com.dsl.anime.tracker.rest.dto.Anime;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;
import java.util.Optional;

public class AnimeNameValidator implements ConstraintValidator<AnimeName, Anime>
{
    @Autowired
    private AnimeRepository animeRepository;

    @Override
    public boolean isValid(Anime anime, ConstraintValidatorContext constraintValidatorContext)
    {
        boolean isValid;
        if(Objects.nonNull(anime.getId()))
        {
            Optional<AnimeEntity> entity = animeRepository.findByName(anime.getName());
            isValid = !entity.isPresent() || Objects.equals(entity.get().getId(), anime.getId());
        }
        else
        {
            isValid = !animeRepository.findByName(anime.getName()).isPresent();
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
