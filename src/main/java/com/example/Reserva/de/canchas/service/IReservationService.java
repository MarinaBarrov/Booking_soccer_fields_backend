package com.example.Reserva.de.canchas.service;

import com.example.Reserva.de.canchas.entity.domain.Sport;
import com.example.Reserva.de.canchas.entity.dto.ReservationRequestDTO;
import com.example.Reserva.de.canchas.entity.dto.ReservationResponseDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IReservationService {

    ReservationResponseDTO guardar (ReservationRequestDTO reservationRequestDTO);

    Set<ReservationRequestDTO> listarTodos();

    ReservationRequestDTO buscarPorId(Integer id);
    void delete(Integer id);
    void actualizar(Integer id, ReservationRequestDTO reservationRequestDTO);

    List<ReservationResponseDTO> search(Sport sport, String sportFieldName);
}
