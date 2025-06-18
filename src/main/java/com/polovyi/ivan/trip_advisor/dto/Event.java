package com.polovyi.ivan.trip_advisor.dto;

import java.time.LocalDate;

public record Event(String name,
                    String description,
                    LocalDate date) {
}