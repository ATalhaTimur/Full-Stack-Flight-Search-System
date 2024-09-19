package com.TalhaTimur.FlightSearchAPI.presentation;

import com.TalhaTimur.FlightSearchAPI.entity.Airport;
import com.TalhaTimur.FlightSearchAPI.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping
    public ResponseEntity<List<Airport>> getAllAirports() {
        List<Airport> airports = airportService.getAllAirports();
        return new ResponseEntity<>(airports, HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> getAirportByCode(@PathVariable String code) {
        Optional<Airport> airport = airportService.getAirportByCode(code);
        if (airport.isPresent()) {
            return new ResponseEntity<>(airport.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Airport not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> addAirport(@RequestBody Airport airport) {
        try {
            Airport newAirport = airportService.addAirport(airport);
            return new ResponseEntity<>(newAirport, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> updateAirport(@PathVariable String code, @RequestBody Airport updatedAirport) {
        try {
            Airport airport = airportService.updateAirport(code, updatedAirport);
            return new ResponseEntity<>(airport, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> deleteAirport(@PathVariable String code) {
        try {
            airportService.deleteAirport(code);
            return new ResponseEntity<>("Airport deleted successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Airport not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<Airport>> findAirportByCity(@PathVariable String city) {
        List<Airport> airports = airportService.findAirportByCity(city);
        return new ResponseEntity<>(airports, HttpStatus.OK);
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<List<Airport>> findAirportByCountry(@PathVariable String country) {
        List<Airport> airports = airportService.findAirportByCountry(country);
        return new ResponseEntity<>(airports, HttpStatus.OK);
    }
}