/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved
 */

package com.dsl.anime.tracker.handlers;

import com.dsl.anime.tracker.entity.UserEntity;
import com.dsl.anime.tracker.exceptions.BadRequestException;
import com.dsl.anime.tracker.exceptions.NotFoundException;
import com.dsl.anime.tracker.mapper.UserMapper;
import com.dsl.anime.tracker.repository.UserRepository;
import com.dsl.anime.tracker.rest.dto.User;
import com.dsl.anime.tracker.services.UserService;
import com.dsl.anime.tracker.validations.CreateValidation;
import com.dsl.anime.tracker.validations.UpdateValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceHandler implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Validator validator;

    @Autowired
    private UserMapper userMapper;

    public List<User> list()
    {
        return userRepository.findAll().stream().map(userMapper::convert).collect(Collectors.toList());
    }

    public User create(User user)
    {
        Set<ConstraintViolation<User>> errors = validator.validate(user, CreateValidation.class);
        if(!errors.isEmpty()) throw new BadRequestException(errors);
        UserEntity userEntity = userMapper.toEntity(user);
        UserEntity created = userRepository.save(userEntity);

        return userMapper.convert(created);
    }

    public User update(User user)
    {
        if(!userRepository.existsById(user.getId())) throw new NotFoundException();
        Set<ConstraintViolation<User>> errors = validator.validate(user, UpdateValidation.class);
        if(!errors.isEmpty()) throw new BadRequestException(errors);

        UserEntity toBeUpdated = userMapper.toEntity(user);
        UserEntity updated = userRepository.save(toBeUpdated);

        return userMapper.convert(updated);
    }

    public void delete(Long id)
    {
        UserEntity toBeDeleted = userRepository.findById(id).orElseThrow(NotFoundException::new);
        userRepository.delete(toBeDeleted);
    }
}
