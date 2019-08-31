package com.dsl.anime.tracker.entity;

import com.dsl.anime.tracker.mapper.AbstractMapper;
import com.dsl.anime.tracker.rest.dto.AnimeDetails;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class AnimeEntity
{
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date releaseDate;

    private Date nextRenewDate;

    @Column(nullable = false)
    private int renewDays;

    @Column(nullable = false)
    private int currentEpisode;

    @Column(nullable = false)
    private int rating;

    @Column
    private String summary;

    @Column(nullable = false)
    private boolean onAir;
}
