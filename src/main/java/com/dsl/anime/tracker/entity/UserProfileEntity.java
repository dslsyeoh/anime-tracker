package com.dsl.anime.tracker.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "userProfile")
public class UserProfileEntity
{
    @Id
    @GeneratedValue
    private Long id;
}
