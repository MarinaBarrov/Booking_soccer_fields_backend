package com.example.Reserva.de.canchas.controller;

import com.example.Reserva.de.canchas.entity.dto.ReservationRequestDTO;
import com.example.Reserva.de.canchas.entity.dto.ReservationResponseDTO;
import com.example.Reserva.de.canchas.service.implementation.ReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservas")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationResponseDTO> save(@Valid @RequestBody ReservationRequestDTO reservationRequestDTO){
        return ResponseEntity.ok(reservationService.guardar(reservationRequestDTO));
    }

}
