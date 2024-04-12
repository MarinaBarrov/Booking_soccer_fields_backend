package com.example.Reserva.de.canchas.entity;

import com.example.Reserva.de.canchas.entity.domain.Sport;
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
public class ReservationRequestDTO {
    @NotNull
    private Sport sport;
    @NotNull
    private LocalDate date;
    @NotNull
    @Size(min = 12, max = 14)
    private String phone;
    @NotBlank
    @Pattern(regexp = "[0-9]{2}:[0-9]{2}")
    private String hour;
}
