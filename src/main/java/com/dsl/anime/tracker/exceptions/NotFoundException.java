package com.dsl.anime.tracker.exceptions;

import org.omg.CosNaming.NamingContextPackage.NotFound;

public class NotFoundException extends RuntimeException
{
    public NotFoundException()
    {
        super("Record not found");
    }
}
