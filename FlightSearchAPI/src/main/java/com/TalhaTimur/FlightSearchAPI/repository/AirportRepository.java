package com.TalhaTimur.FlightSearchAPI.repository;

import com.TalhaTimur.FlightSearchAPI.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, String> {

    @Query(value = "SELECT * FROM airport WHERE city = :city", nativeQuery = true)
    List<Airport> findByCity(@Param("city") String city);

    @Query(value = "SELECT * FROM airport WHERE country = :country", nativeQuery = true)
    List<Airport> findByCountry(@Param("country") String country);
}