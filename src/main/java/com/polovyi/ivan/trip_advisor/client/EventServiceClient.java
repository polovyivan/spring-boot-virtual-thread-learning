package com.polovyi.ivan.trip_advisor.client;

import com.polovyi.ivan.trip_advisor.dto.Accomodation;
import com.polovyi.ivan.trip_advisor.dto.Event;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
public class EventServiceClient {
    private final RestClient restClient;

    public List<Event> getEvents(String airportCode) {
        return restClient.get()
                .uri("{airportCode}", airportCode)
                .retrieve()
                .body(new ParameterizedTypeReference<List<Event>>() {
                });
    }
}
