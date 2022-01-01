/*----------------------------------------------------------------------
	FILE        : DateTimeConverter.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 30.09.2020

	DateTimeConverter class for date time operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.datetime;

import java.time.*;

public final class DateTimeConverter {
    private DateTimeConverter()
    {
    }

    public static long toMilliseconds(LocalDateTime localDateTime)
    {
        return toMilliseconds(localDateTime, ZoneId.systemDefault());
    }

    public static long toMilliseconds(LocalDateTime localDateTime, ZoneId zoneId)
    {
        return localDateTime.atZone(zoneId).toInstant().toEpochMilli();
    }

    public static LocalDateTime toLocalDateTime(long milliseconds)
    {
        return toLocalDateTime(milliseconds, ZoneId.systemDefault());
    }

    public static LocalDateTime toLocalDateTime(long milliseconds, ZoneId zoneId)
    {
        return Instant.ofEpochMilli(milliseconds).atZone(zoneId).toLocalDateTime();
    }

    public static long toMilliseconds(LocalDate localDate)
    {
        return toMilliseconds(localDate, ZoneId.systemDefault());
    }

    public static long toMilliseconds(LocalDate localDate, ZoneId zoneId)
    {
        return localDate.atStartOfDay(zoneId).toInstant().toEpochMilli();
    }

    public static LocalDate toLocalDate(long milliseconds)
    {
        return toLocalDate(milliseconds, ZoneId.systemDefault());
    }

    public static LocalDate toLocalDate(long milliseconds, ZoneId zoneId)
    {
        return Instant.ofEpochMilli(milliseconds).atZone(zoneId).toLocalDate();
    }
}
