package com.dsl.anime.tracker.exceptions;

public class NotFoundException extends RuntimeException
{
    public NotFoundException()
    {
        super("Record not found");
    }
}
