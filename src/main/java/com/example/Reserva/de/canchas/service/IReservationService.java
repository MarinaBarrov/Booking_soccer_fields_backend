package com.example.Reserva.de.canchas.service;

import com.example.Reserva.de.canchas.entity.dto.ReservationRequestDTO;
import com.example.Reserva.de.canchas.entity.dto.ReservationResponseDTO;

import java.util.Set;

public interface IReservationService {

    ReservationResponseDTO guardar (ReservationRequestDTO reservationRequestDTO);

    Set<ReservationRequestDTO> listarTodos();

    ReservationRequestDTO buscarPorId(Integer id);
    void eliminar(Integer id);
    void actualizar(Integer id, ReservationRequestDTO reservationRequestDTO);
}
