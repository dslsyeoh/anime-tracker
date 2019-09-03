/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.anime.tracker.exceptions.dto;

import lombok.Data;

@Data
public class Violation
{
    private String field;
    private String error;
}
