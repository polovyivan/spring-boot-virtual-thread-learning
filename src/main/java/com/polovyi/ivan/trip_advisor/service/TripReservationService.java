package com.polovyi.ivan.trip_advisor.service;


import com.polovyi.ivan.trip_advisor.client.FlightReservationServiceClient;
import com.polovyi.ivan.trip_advisor.client.FlightSearchServiceClient;
import com.polovyi.ivan.trip_advisor.dto.Flight;
import com.polovyi.ivan.trip_advisor.dto.FlightReservationRequest;
import com.polovyi.ivan.trip_advisor.dto.FlightReservationResponse;
import com.polovyi.ivan.trip_advisor.dto.TripReservationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
@RequiredArgsConstructor
public class TripReservationService {

    private final FlightSearchServiceClient searchServiceClient;
    private final FlightReservationServiceClient reservationServiceClient;

    public FlightReservationResponse reserve(TripReservationRequest request){
        var flights = this.searchServiceClient.getFlights(request.departure(), request.arrival());
        var bestDeal = flights.stream().min(Comparator.comparingInt(Flight::price));
        var flight = bestDeal.orElseThrow(() -> new IllegalStateException("no flights found"));
        var reservationRequest = new FlightReservationRequest(request.departure(), request.arrival(), flight.flightNumber(), request.date());
        return this.reservationServiceClient.reserve(reservationRequest);
    }

}