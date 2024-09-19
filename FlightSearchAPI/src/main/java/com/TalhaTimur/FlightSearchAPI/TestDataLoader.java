package com.TalhaTimur.FlightSearchAPI;

import com.TalhaTimur.FlightSearchAPI.entity.Airport;
import com.TalhaTimur.FlightSearchAPI.entity.Flight;
import com.TalhaTimur.FlightSearchAPI.repository.AirportRepository;
import com.TalhaTimur.FlightSearchAPI.repository.FlightRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TestDataLoader {

    @Bean
    CommandLineRunner initDatabase(AirportRepository airportRepository, FlightRepository flightRepository) {
        return args -> {
            // Havaalanı verisi ekleyelim
            Airport airport1 = new Airport("JFK", "John F. Kennedy International Airport", "New York", "USA");
            Airport airport2 = new Airport("LHR", "London Heathrow Airport", "London", "UK");
            airportRepository.save(airport1);
            airportRepository.save(airport2);

            // Uçuş verisi ekleyelim
            Flight flight1 = new Flight("AA100", airport1, airport2, "09:00", "17:00", "American Airlines");
            Flight flight2 = new Flight("BA200", airport2, airport1, "10:00", "18:00", "British Airways");
            flightRepository.save(flight1);
            flightRepository.save(flight2);
        };
    }
}