package com.dsl.anime.tracker.validators;

import com.dsl.anime.tracker.constraints.Anime;
import com.dsl.anime.tracker.entity.AnimeEntity;
import com.dsl.anime.tracker.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class AnimeValidator implements ConstraintValidator<Anime, AnimeEntity>
{
    @Autowired
    private AnimeRepository animeRepository;

    @Override
    public boolean isValid(AnimeEntity animeEntity, ConstraintValidatorContext constraintValidatorContext)
    {
        return !animeRepository.findByName(animeEntity.getName()).isPresent();
    }
}
