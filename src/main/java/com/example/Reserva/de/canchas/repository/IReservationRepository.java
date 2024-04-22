package com.example.Reserva.de.canchas.repository;

import com.example.Reserva.de.canchas.entity.domain.Reservation;
import com.example.Reserva.de.canchas.entity.domain.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findBySportFieldSportAndSportFieldName(Sport sport, String sportFieldName);
    List<Reservation> findBySportFieldSport(Sport sport);
    List<Reservation> findBySportFieldName(String sportFieldName);
}
