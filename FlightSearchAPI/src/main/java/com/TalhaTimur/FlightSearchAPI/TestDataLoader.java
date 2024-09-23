package com.TalhaTimur.FlightSearchAPI;

import com.TalhaTimur.FlightSearchAPI.entity.Airport;
import com.TalhaTimur.FlightSearchAPI.entity.Flight;
import com.TalhaTimur.FlightSearchAPI.repository.AirportRepository;
import com.TalhaTimur.FlightSearchAPI.repository.FlightRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
public class TestDataLoader {


    @Bean
    CommandLineRunner initDatabase(AirportRepository airportRepository, FlightRepository flightRepository) {
        return args -> {
            // 20 farklı havaalanı oluşturdum
            List<Airport> airports = Arrays.asList(
                    new Airport("JFK", "John F. Kennedy International Airport", "New York", "USA"),
                    new Airport("LHR", "London Heathrow Airport", "London", "UK"),
                    new Airport("IST", "Istanbul Airport", "Istanbul", "Turkey"),
                    new Airport("DXB", "Dubai International Airport", "Dubai", "UAE"),
                    new Airport("HND", "Tokyo Haneda Airport", "Tokyo", "Japan"),
                    new Airport("CDG", "Charles de Gaulle Airport", "Paris", "France"),
                    new Airport("SIN", "Changi Airport", "Singapore", "Singapore"),
                    new Airport("FRA", "Frankfurt Airport", "Frankfurt", "Germany"),
                    new Airport("SYD", "Sydney Airport", "Sydney", "Australia"),
                    new Airport("GRU", "São Paulo Guarulhos International Airport", "São Paulo", "Brazil"),
                    new Airport("LAX", "Los Angeles International Airport", "Los Angeles", "USA"),
                    new Airport("ORD", "O'Hare International Airport", "Chicago", "USA"),
                    new Airport("SFO", "San Francisco International Airport", "San Francisco", "USA"),
                    new Airport("YYZ", "Toronto Pearson International Airport", "Toronto", "Canada"),
                    new Airport("MEX", "Mexico City International Airport", "Mexico City", "Mexico"),
                    new Airport("AMS", "Amsterdam Schiphol Airport", "Amsterdam", "Netherlands"),
                    new Airport("HKG", "Hong Kong International Airport", "Hong Kong", "China"),
                    new Airport("JNB", "OR Tambo International Airport", "Johannesburg", "South Africa"),
                    new Airport("MEL", "Melbourne Airport", "Melbourne", "Australia"),
                    new Airport("BOM", "Chhatrapati Shivaji Maharaj International Airport", "Mumbai", "India")
            );

            airportRepository.saveAll(airports);



            // 10 farklı uçuş eklidim
            List<Flight> flights = Arrays.asList(
                    new Flight("AA100", airports.get(0), airports.get(1), LocalDateTime.of(2024, 10, 1, 9, 0), LocalDateTime.of(2024, 10, 1, 17, 0), "American Airlines"),
                    new Flight("BA200", airports.get(1), airports.get(0), LocalDateTime.of(2024, 10, 2, 10, 0), LocalDateTime.of(2024, 10, 2, 18, 0), "British Airways"),
                    new Flight("TK2024", airports.get(2), airports.get(0), LocalDateTime.of(2024, 10, 1, 10, 0), LocalDateTime.of(2024, 10, 1, 16, 0), "Turkish Airlines"),
                    new Flight("EK400", airports.get(3), airports.get(0), LocalDateTime.of(2024, 10, 3, 11, 0), LocalDateTime.of(2024, 10, 3, 19, 0), "Emirates"),
                    new Flight("JL500", airports.get(4), airports.get(0), LocalDateTime.of(2024, 10, 4, 12, 0), LocalDateTime.of(2024, 10, 4, 20, 0), "Japan Airlines"),
                    new Flight("AF600", airports.get(5), airports.get(0), LocalDateTime.of(2024, 10, 5, 13, 0), LocalDateTime.of(2024, 10, 5, 21, 0), "Air France"),
                    new Flight("SQ700", airports.get(6), airports.get(0), LocalDateTime.of(2024, 10, 6, 14, 0), LocalDateTime.of(2024, 10, 6, 22, 0), "Singapore Airlines"),
                    new Flight("LH800", airports.get(7), airports.get(0), LocalDateTime.of(2024, 10, 7, 15, 0), LocalDateTime.of(2024, 10, 7, 23, 0), "Lufthansa"),
                    new Flight("QF900", airports.get(8), airports.get(0), LocalDateTime.of(2024, 10, 8, 16, 0), LocalDateTime.of(2024, 10, 9, 0, 0), "Qantas"), // 24:00 yerine 00:00
                    new Flight("LA1000", airports.get(9), airports.get(0), LocalDateTime.of(2024, 10, 9, 17, 0), LocalDateTime.of(2024, 10, 10, 1, 0), "LATAM Airlines") // Saat ve tarih güncellendi
            );

            flightRepository.saveAll(flights);
        };
    }
}