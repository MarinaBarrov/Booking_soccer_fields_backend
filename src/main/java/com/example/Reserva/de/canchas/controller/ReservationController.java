package com.example.Reserva.de.canchas.controller;

import com.example.Reserva.de.canchas.entity.domain.Sport;
import com.example.Reserva.de.canchas.entity.domain.SportField;
import com.example.Reserva.de.canchas.entity.dto.ReservationRequestDTO;
import com.example.Reserva.de.canchas.entity.dto.ReservationRequestUpdateDTO;
import com.example.Reserva.de.canchas.entity.dto.ReservationResponseDTO;
import com.example.Reserva.de.canchas.service.implementation.ReservationService;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationResponseDTO> save(@Valid @RequestBody ReservationRequestDTO reservationRequestDTO) {
        return ResponseEntity.ok(reservationService.guardar(reservationRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<ReservationResponseDTO>> search(@Nullable @RequestParam Sport sport, @Nullable @RequestParam("sport_field_name") String sportFieldName) {
        return ResponseEntity.ok(reservationService.search(sport, sportFieldName));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        reservationService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationResponseDTO> updato(@PathVariable Integer id, @Valid @RequestBody ReservationRequestUpdateDTO reservationRequestUpdateDTO) {
        return ResponseEntity.ok(reservationService.update(id, reservationRequestUpdateDTO));
    }
}
