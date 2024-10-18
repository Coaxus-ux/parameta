package org.coaxus.employeeclient.Utils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.coaxus.employeeclient.interfaces.Adult;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class AdultValidator implements ConstraintValidator<Adult, Date> {

    @Override
    public boolean isValid(Date birthDate, ConstraintValidatorContext context) {
        if (birthDate == null) {
            return false;
        }
        LocalDate birthLocalDate = new java.sql.Date(birthDate.getTime()).toLocalDate();
        LocalDate today = LocalDate.now();
        return Period.between(birthLocalDate, today).getYears() >= 18;
    }
}
