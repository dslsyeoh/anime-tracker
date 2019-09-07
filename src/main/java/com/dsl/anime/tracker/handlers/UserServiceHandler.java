/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.anime.tracker.handlers;

import com.dsl.anime.tracker.entity.UserEntity;
import com.dsl.anime.tracker.exceptions.BadRequestException;
import com.dsl.anime.tracker.exceptions.NotFoundException;
import com.dsl.anime.tracker.repository.UserRepository;
import com.dsl.anime.tracker.rest.dto.User;
import com.dsl.anime.tracker.services.UserService;
import com.dsl.anime.tracker.validations.CreateValidation;
import com.dsl.anime.tracker.validations.UpdateValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceHandler implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Validator validator;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<User> list()
    {
        return null;
    }

    public User create(User user)
    {
        Set<ConstraintViolation<User>> errors = validator.validate(user, CreateValidation.class);
        if(!errors.isEmpty()) throw new BadRequestException(errors);
        UserEntity userEntity = toEntity(user);
        UserEntity created = userRepository.save(userEntity);

        return null;
    }

    public User update(User user)
    {
        UserEntity entity = userRepository.findById(user.getId()).orElseThrow(NotFoundException::new);
        Set<ConstraintViolation<User>> errors = validator.validate(user, UpdateValidation.class);
        if(!errors.isEmpty()) throw new BadRequestException(errors);

        UserEntity toBeUpdated = toEntity(user, entity);
        UserEntity updated = userRepository.save(toBeUpdated);

        return null;
    }

    public void delete(Long id)
    {
        UserEntity toBeDeleted = userRepository.findById(id).orElseThrow(NotFoundException::new);
        userRepository.delete(toBeDeleted);
    }

    private UserEntity toEntity(User user)
    {
        return toEntity(user, new UserEntity());
    }

    private UserEntity toEntity(User user, UserEntity userEntity)
    {
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));

        return userEntity;
    }
}
