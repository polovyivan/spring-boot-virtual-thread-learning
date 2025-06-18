package com.polovyi.ivan.trip_advisor.dto;

import java.util.List;

public record LocalRecommendations(List<String> restaurants,
                                   List<String> sightseeing) {
}