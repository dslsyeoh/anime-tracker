/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.anime.tracker.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "anime")
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

    @OneToOne(mappedBy = "anime")
    private UserHistoryEntity userHistory;
}

