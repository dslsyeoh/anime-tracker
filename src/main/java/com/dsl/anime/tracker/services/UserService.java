package com.dsl.anime.tracker.services;

import com.dsl.anime.tracker.rest.dto.UserDetails;

import java.util.List;

public interface UserService
{
    List<UserDetails> list();

    void create(UserDetails userDetails);

    void update(UserDetails userDetails);

    void delete(Long id);
}
