/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved
 */

package com.dsl.anime.tracker.exceptions;

public class NotFoundException extends RuntimeException
{
    public NotFoundException()
    {
        super("Record not found");
    }
}
