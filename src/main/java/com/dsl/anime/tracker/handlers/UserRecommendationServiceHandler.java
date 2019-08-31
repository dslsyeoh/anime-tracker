package com.dsl.anime.tracker.handlers;

import com.dsl.anime.tracker.rest.dto.UserRecommendationDetails;
import com.dsl.anime.tracker.services.UserRecommendationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRecommendationServiceHandler implements UserRecommendationService
{
    public List<UserRecommendationDetails> list()
    {
        return null;
    }

    public List<UserRecommendationDetails> search(Long id)
    {
        return null;
    }

    public void create(UserRecommendationDetails userRecommendationDetails)
    {

    }

    public void update(UserRecommendationDetails userRecommendationDetails)
    {

    }

    public void delete(Long id)
    {

    }
}
