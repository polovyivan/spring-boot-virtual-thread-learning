package com.polovyi.ivan.trip_advisor.dto;

import java.util.List;

public record TripPlan(String airportCode,
                       List<Accomodation> accommodations,
                       Weather weather,
                       List<Event> events,
                       LocalRecommendations localRecommendations,
                       Transportation transportation) {
}