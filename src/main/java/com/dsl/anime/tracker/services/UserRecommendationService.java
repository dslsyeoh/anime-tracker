/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.anime.tracker.services;


import com.dsl.anime.tracker.rest.dto.UserRecommendationDetails;

import java.util.List;

public interface UserRecommendationService
{
    List<UserRecommendationDetails> list();

    List<UserRecommendationDetails> search(Long id);

    void create(UserRecommendationDetails userRecommendationDetails);

    void update(UserRecommendationDetails userRecommendationDetails);

    void delete(Long id);
}
