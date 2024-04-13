package com.example.Reserva.de.canchas.entity.dto;

import com.example.Reserva.de.canchas.entity.domain.Sport;
import com.example.Reserva.de.canchas.entity.domain.SportField;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponseDTO {

    private LocalDate date;

    private String phone;

    private String hour;

    private SportFieldDTO sportField;

}
