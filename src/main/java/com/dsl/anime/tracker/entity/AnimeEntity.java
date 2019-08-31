package com.dsl.anime.tracker.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table
@Data
public class AnimeEntity
{
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date releaseDate;

    private Date nextRenewDate;

    @Min(value = 1)
    @Column(nullable = false)
    private int renewDays;

    @Min(value = 1)
    @Column(nullable = false)
    private int currentEpisode;

    @Min(value = 1)
    @Column(nullable = false)
    private int rating;

    @Column
    private String summary;

    @Column(nullable = false)
    private boolean onAir;
}
