package com.TalhaTimur.FlightSearchAPI.service;

import com.TalhaTimur.FlightSearchAPI.entity.Airport;
import com.TalhaTimur.FlightSearchAPI.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Optional<Airport> getAirportByCode(String code) {
        return airportRepository.findById(code);
    }

    public Airport addAirport(Airport airport) {
        Optional<Airport> existingAirport = airportRepository.findById(airport.getAirportCode());
        if (existingAirport.isPresent()) {
            throw new IllegalArgumentException("Airport already exists");
        }
        return airportRepository.save(airport);
    }

    public Airport updateAirport(String airportCode, Airport updatedAirport) {
        Optional<Airport> existingAirport = airportRepository.findById(airportCode);
        if (!existingAirport.isPresent()) {
            throw new IllegalArgumentException("Airport not found");
        }
        Airport airport = existingAirport.get();
        airport.setAirportName(updatedAirport.getAirportName());
        airport.setCity(updatedAirport.getCity());
        airport.setCountry(updatedAirport.getCountry());
        return airportRepository.save(airport);
    }

    public void deleteAirport(String code) {
        airportRepository.deleteById(code);
    }

    public List<Airport> findAirportByCity(String city) {
        return airportRepository.findByCity(city);
    }

    public List<Airport> findAirportByCountry(String country) {
        return airportRepository.findByCountry(country);
    }
}