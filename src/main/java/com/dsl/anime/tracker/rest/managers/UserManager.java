/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved
 */

package com.dsl.anime.tracker.rest.managers;

import com.dsl.anime.tracker.rest.client.RestClient;
import com.dsl.anime.tracker.rest.dto.User;
import com.dsl.anime.tracker.rest.utils.UrlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserManager
{
    @Autowired
    private RestClient restClient;

    private static final String BASE_URL = "api/users";

    public User create(User user)
    {
        return restClient.putObject(BASE_URL, user, User.class);
    }

    public User update(User user)
    {
        return restClient.postObject(BASE_URL, user, User.class);
    }

    public void delete(Long id)
    {
        String url = UrlBuilder.build(BASE_URL, id);
        restClient.deleteObject(url, User.class);
    }
}
