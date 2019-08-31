package com.dsl.anime.tracker.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "userRole")
public class UserRoleEntity
{
    @Id
    @GeneratedValue
    private Long id;
}
