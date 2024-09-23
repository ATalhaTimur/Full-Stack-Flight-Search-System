package com.TalhaTimur.FlightSearchAPI.presentation;

import com.TalhaTimur.FlightSearchAPI.entity.Flight;
import com.TalhaTimur.FlightSearchAPI.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/add")
    public ResponseEntity<String> addFlight(@RequestBody Flight flight) {
        try {
            Flight newFlight = flightService.addFlight(flight);
            return new ResponseEntity<>("Flight added successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/update/{flightNumber}")
    public ResponseEntity<String> updateFlight(@PathVariable String flightNumber, @RequestBody Flight updatedFlight) {
        try {
            Flight flight = flightService.updateFlight(flightNumber, updatedFlight);
            return new ResponseEntity<>("Flight updated successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{flightNumber}")
    public ResponseEntity<?> getFlightByNumber(@PathVariable String flightNumber) {
        Optional<Flight> flight = flightService.getFlightByNumber(flightNumber);
        if (flight.isPresent()) {
            return ResponseEntity.ok(flight.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight not found");
        }
    }
    @GetMapping("/find-available-flights")
    public ResponseEntity<List<Flight>> findAvailableFlights(
            @RequestParam String departureAirportCode,
            @RequestParam String arrivalAirportCode,
            @RequestParam String departureDate,
            @RequestParam(required = false) String returnDate) {

        List<Flight> flights = flightService.findFlights(departureAirportCode, arrivalAirportCode, departureDate, returnDate);

        if (flights.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/departure/{departureAirportCode}")
    public List<Flight> getFlightsByDepartureAirportCode(@PathVariable String departureAirportCode) {
        return flightService.findByDepartureAirportCode(departureAirportCode);
    }

    @GetMapping("/arrival/{arrivalAirportCode}")
    public List<Flight> getFlightsByArrivalAirportCode(@PathVariable String arrivalAirportCode) {
        return flightService.findByArrivalAirportCode(arrivalAirportCode);
    }

    @GetMapping("/departure-date/{departureDate}")
    public List<Flight> getFlightsByDepartureDate(@PathVariable String departureDate) {
        return flightService.findByDepartureDate(departureDate);
    }

    @DeleteMapping("/delete/{flightNumber}")
    public ResponseEntity<String> deleteFlight(@PathVariable String flightNumber) {
        try {
            flightService.deleteFlight(flightNumber);
            return new ResponseEntity<>("Flight deleted successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Flight not found", HttpStatus.NOT_FOUND);
        }
    }
}