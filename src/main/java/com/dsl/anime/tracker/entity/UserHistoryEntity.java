/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved
 */

package com.dsl.anime.tracker.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "userHistory", indexes = { @Index(name = "indexes", columnList = "anime_id, user_id", unique = true) })
public class UserHistoryEntity
{
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "anime_id", nullable = false)
    private AnimeEntity anime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(nullable = false)
    private Long currentEpisode;
}
