package com.polovyi.ivan.trip_advisor.client;

import com.polovyi.ivan.trip_advisor.dto.FlightReservationRequest;
import com.polovyi.ivan.trip_advisor.dto.FlightReservationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
public class FlightReservationServiceClient {

    private final RestClient client;

    public FlightReservationResponse reserve(FlightReservationRequest request) {
        return this.client.post()
                          .body(request)
                          .retrieve()
                          .body(FlightReservationResponse.class);
    }

}