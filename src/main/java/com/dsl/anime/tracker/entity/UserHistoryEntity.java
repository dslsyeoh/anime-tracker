package com.dsl.anime.tracker.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "userHistory")
public class UserHistoryEntity
{
    @Id
    @GeneratedValue
    private Long id;
}
