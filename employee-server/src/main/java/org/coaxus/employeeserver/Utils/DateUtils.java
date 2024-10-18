package org.coaxus.employeeserver.Utils;

import java.time.Period;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {

    public static String calculatePeriod(LocalDate startDate, LocalDate endDate) {
        Period period = Period.between(startDate, endDate);
        return formatPeriod(period);
    }

    private static String formatPeriod(Period period) {
        return String.format("%d years, %d months, %d days",
                period.getYears(), period.getMonths(), period.getDays());
    }
    public static LocalDate convertToLocalDate(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}

