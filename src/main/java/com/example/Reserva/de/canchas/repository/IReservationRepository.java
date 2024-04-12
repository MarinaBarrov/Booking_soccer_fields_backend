package com.example.Reserva.de.canchas.repository;

import com.example.Reserva.de.canchas.entity.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Integer> {
}
