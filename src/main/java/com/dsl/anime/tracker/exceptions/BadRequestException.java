package com.dsl.anime.tracker.exceptions;

public class BadRequestException extends RuntimeException
{
    public BadRequestException()
    {
        super("Bad request");
    }
}
