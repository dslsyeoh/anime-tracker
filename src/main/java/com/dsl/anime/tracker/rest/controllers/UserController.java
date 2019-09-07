/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.anime.tracker.rest.controllers;

import com.dsl.anime.tracker.rest.dto.User;
import com.dsl.anime.tracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController
{
    @Autowired
    public UserService userService;

    @PutMapping
    public User create(@RequestBody User user)
    {
        return userService.create(user);
    }

    @PostMapping
    public User update(@RequestBody User user)
    {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestParam(name = "id") Long id)
    {
        userService.delete(id);
    }
}
