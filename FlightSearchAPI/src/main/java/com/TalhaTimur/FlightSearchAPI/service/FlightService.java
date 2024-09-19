package com.TalhaTimur.FlightSearchAPI.service;

import com.TalhaTimur.FlightSearchAPI.entity.Flight;
import com.TalhaTimur.FlightSearchAPI.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightByNumber(String flightNumber) {
        return flightRepository.findById(flightNumber);
    }

    public Flight addFlight(Flight flight) {
        Optional<Flight> existingFlight = flightRepository.findById(flight.getFlightNumber());
        if (existingFlight.isPresent()) {
            throw new IllegalArgumentException("Flight already exists");
        }
        return flightRepository.save(flight);
    }

    public Flight updateFlight(String flightNumber, Flight updatedFlight) {
        Optional<Flight> existingFlight = flightRepository.findById(flightNumber);
        if (!existingFlight.isPresent()) {
            throw new IllegalArgumentException("Flight not found");
        }
        Flight flight = existingFlight.get();
        flight.setArrivalAirport(updatedFlight.getArrivalAirport());
        flight.setDepartureAirport(updatedFlight.getDepartureAirport());
        flight.setDepartureTime(updatedFlight.getDepartureTime());
        flight.setArrivalTime(updatedFlight.getArrivalTime());
        flight.setAirline(updatedFlight.getAirline());
        return flightRepository.save(flight);
    }

    public void deleteFlight(String flightNumber) {
        flightRepository.deleteById(flightNumber);
    }

    public List<Flight> findByDepartureAirportCode(String departureAirportCode) {
        return flightRepository.findByDepartureAirportCode(departureAirportCode);
    }

    public List<Flight> findByArrivalAirportCode(String arrivalAirportCode) {
        return flightRepository.findByArrivalAirportCode(arrivalAirportCode);
    }

    public List<Flight> findByDepartureDate(String departureDate) {
        return flightRepository.findByDepartureDate(departureDate);
    }
}