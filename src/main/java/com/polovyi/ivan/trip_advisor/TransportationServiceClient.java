package com.polovyi.ivan.trip_advisor;


import com.polovyi.ivan.trip_advisor.dto.Transportation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
public class TransportationServiceClient {

    private final RestClient restClient;

    public Transportation getTransportation(String airportCode) {
        return this.restClient.get()
                              .uri("{airportCode}", airportCode)
                              .retrieve()
                              .body(Transportation.class);
    }

}