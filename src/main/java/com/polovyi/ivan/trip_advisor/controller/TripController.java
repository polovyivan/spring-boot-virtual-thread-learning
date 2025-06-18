package com.polovyi.ivan.trip_advisor.controller;


import com.polovyi.ivan.trip_advisor.dto.FlightReservationResponse;
import com.polovyi.ivan.trip_advisor.dto.TripPlan;
import com.polovyi.ivan.trip_advisor.dto.TripReservationRequest;
import com.polovyi.ivan.trip_advisor.service.TripPlanService;
import com.polovyi.ivan.trip_advisor.service.TripReservationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("trip")
@RequiredArgsConstructor
public class TripController {
    Logger logger = LoggerFactory.getLogger(TripController.class);

    private final TripPlanService planService;
    private final TripReservationService reservationService;

    @GetMapping("{airportCode}")
    public TripPlan planTrip(@PathVariable String airportCode){
        logger.info("airportCode: {}, is Virtual {}", airportCode, Thread.currentThread().isVirtual());
        return this.planService.getTripPlan(airportCode);
    }

    @PostMapping("reserve")
    public FlightReservationResponse reserveFlight(@RequestBody TripReservationRequest request){
        return this.reservationService.reserve(request);
    }

}