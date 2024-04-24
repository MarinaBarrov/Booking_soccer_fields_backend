package com.example.Reserva.de.canchas.service;

import com.example.Reserva.de.canchas.entity.domain.Sport;
import com.example.Reserva.de.canchas.entity.dto.ReservationRequestDTO;
import com.example.Reserva.de.canchas.entity.dto.ReservationRequestUpdateDTO;
import com.example.Reserva.de.canchas.entity.dto.ReservationResponseDTO;

import java.util.List;
import java.util.Set;

public interface IReservationService {

    ReservationResponseDTO guardar (ReservationRequestDTO reservationRequestDTO);

    Set<ReservationRequestDTO> listarTodos();

    ReservationRequestDTO buscarPorId(Integer id);
    void delete(Integer id);
    ReservationResponseDTO update(Integer id, ReservationRequestUpdateDTO reservationRequestUpDateDTO);

    List<ReservationResponseDTO> search(Sport sport, String sportFieldName);
}
