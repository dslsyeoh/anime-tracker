package com.dsl.anime.tracker.services;

import com.dsl.anime.tracker.rest.dto.UserPendingDetails;

import java.util.List;

public interface UserPendingService
{
    List<UserPendingDetails> list();

    List<UserPendingDetails> search(Long id);

    void create(UserPendingDetails userPendingDetails);

    void update(UserPendingDetails userPendingDetails);

    void delete(Long id);
}
