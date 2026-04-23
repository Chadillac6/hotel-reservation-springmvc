package com.demo.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.Year;

/**
 * Converts a String to a {@code Year}, enforcing exactly 4 digits.
 * Rejects values like "18" that {@code Year.parse} would accept as year 18 AD.
 */
@Component
public class YearConverter implements Converter<String, Year> {
    @Override
    public Year convert(String value) {
        if (value == null || !value.matches("\\d{4}")) {
            throw new IllegalArgumentException("Year must be exactly 4 digits");
        }
        return Year.parse(value);
    }
}
