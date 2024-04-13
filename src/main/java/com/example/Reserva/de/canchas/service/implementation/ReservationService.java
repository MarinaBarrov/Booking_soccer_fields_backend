package com.example.Reserva.de.canchas.service.implementation;

import com.example.Reserva.de.canchas.entity.dto.ReservationRequestDTO;
import com.example.Reserva.de.canchas.entity.domain.Reservation;
import com.example.Reserva.de.canchas.entity.domain.SportField;
import com.example.Reserva.de.canchas.entity.dto.ReservationResponseDTO;
import com.example.Reserva.de.canchas.exception.ResourceNotFoundException;
import com.example.Reserva.de.canchas.repository.IReservationRepository;
import com.example.Reserva.de.canchas.repository.ISportFieldRepository;
import com.example.Reserva.de.canchas.service.IReservationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ReservationService implements IReservationService {

    @Autowired
    IReservationRepository reservationRepository;
    @Autowired
    ISportFieldRepository sportFieldRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public ReservationResponseDTO guardar(ReservationRequestDTO reservationRequestDTO) {
        Reservation reservation = mapper.convertValue(reservationRequestDTO, Reservation.class);
        Set<SportField> sportFieldList = sportFieldRepository.findBySport(reservationRequestDTO.getSport());

        SportField sportFieldFound = null;

        for (SportField sportField : sportFieldList) {
            Boolean isAvailable = sportField.getAvailability().get(reservation.getHour());
            if (isAvailable != null && isAvailable) {
                //TODO: buscar si existe reservas para esa fecha en esa cancha
                sportFieldFound = sportField;
                break;
            }
        }
        if (sportFieldFound == null) {
            throw new ResourceNotFoundException("There is not sport field available at the requested time");
        }
        reservation.setSportField(sportFieldFound);
        Reservation reservationSaved = reservationRepository.save(reservation);
        return mapper.convertValue(reservationSaved, ReservationResponseDTO.class);

    }

    @Override
    public Set<ReservationRequestDTO> listarTodos() {
        List<Reservation> reservations = reservationRepository.findAll();
        if (reservations.isEmpty()) {
            throw new RuntimeException("No se encontraron reservas para listar.");
        }
        Set<ReservationRequestDTO> reservationRequestDTOS = new HashSet<>();

        for (Reservation reservation : reservations) {
            reservationRequestDTOS.add(mapper.convertValue(reservation, ReservationRequestDTO.class));
        }
        return reservationRequestDTOS;
    }


    @Override
    public ReservationRequestDTO buscarPorId(Integer id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        ReservationRequestDTO reservationRequestDTO = null;
        if (reservation.isPresent()) {
            reservationRequestDTO = mapper.convertValue(reservation, ReservationRequestDTO.class);
        } else {

            throw new RuntimeException("No se encontro la reserva con id " + id);

        }
        return reservationRequestDTO;
    }

    @Override
    public void eliminar(Integer id) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        if (reservationOptional.isPresent()) {
            reservationRepository.deleteById(id);
        } else {
            throw new RuntimeException("No se encontro la reserva con id" + id);
        }
    }

    @Override
    public void actualizar(Integer id, ReservationRequestDTO reservationRequestDTO) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);

        if (reservationOptional.isPresent()) {
            Reservation reservation = mapper.convertValue(reservationOptional, Reservation.class);
            reservationRepository.save(reservation);
        } else {
            throw new RuntimeException("La reserva con id " + id + " no fue encontrado para actualizar");
        }
    }
}
