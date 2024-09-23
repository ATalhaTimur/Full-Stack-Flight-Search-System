package com.TalhaTimur.FlightSearchAPI.repository;

import com.TalhaTimur.FlightSearchAPI.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {

    @Query(value = "SELECT * FROM flight WHERE departure_airport_code = :departureAirportCode", nativeQuery = true)
    List<Flight> findByDepartureAirportCode(@Param("departureAirportCode") String departureAirportCode);

    @Query(value = "SELECT * FROM flight WHERE arrival_airport_code = :arrivalAirportCode", nativeQuery = true)
    List<Flight> findByArrivalAirportCode(@Param("arrivalAirportCode") String arrivalAirportCode);

    @Query(value = "SELECT * FROM flight WHERE departure_date = :departureDate", nativeQuery = true)
    List<Flight> findByDepartureDate(@Param("departureDate") String departureDate);

    @Query("SELECT f FROM Flight f WHERE f.departureAirport.airportCode = :departureAirportCode AND f.arrivalAirport.airportCode = :arrivalAirportCode AND f.departureTime = :departureDate")
    List<Flight> findByDepartureAndArrivalAndDate(
            @Param("departureAirportCode") String departureAirportCode,
            @Param("arrivalAirportCode") String arrivalAirportCode,
            @Param("departureDate") String departureDate
    );

    @Query("SELECT f FROM Flight f WHERE f.departureAirport.airportCode = :departureAirportCode AND f.arrivalAirport.airportCode = :arrivalAirportCode AND f.departureTime = :departureDate AND f.arrivalTime = :returnDate")
    List<Flight> findByDepartureAndArrivalAndDate(
            @Param("departureAirportCode") String departureAirportCode,
            @Param("arrivalAirportCode") String arrivalAirportCode,
            @Param("departureDate") String departureDate,
            @Param("returnDate") String returnDate
    );
}