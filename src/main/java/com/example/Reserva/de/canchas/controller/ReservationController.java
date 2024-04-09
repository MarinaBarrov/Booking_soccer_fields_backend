package com.example.Reserva.de.canchas.controller;

import com.example.Reserva.de.canchas.entity.ReservationRequestDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservas")
public class ReservationController {

    @PostMapping
    public ResponseEntity<ReservationRequestDTO> save(@Valid @RequestBody ReservationRequestDTO reservationRequestDTO){
        return ResponseEntity.ok(reservationRequestDTO);
    }
}
