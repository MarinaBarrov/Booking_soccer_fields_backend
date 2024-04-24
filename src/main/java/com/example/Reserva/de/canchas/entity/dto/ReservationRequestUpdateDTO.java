package com.example.Reserva.de.canchas.entity.dto;

import jakarta.annotation.Nullable;
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
public class ReservationRequestUpdateDTO {

    @Nullable
    private LocalDate date;
    @Nullable
    @Size(min = 12, max = 14)
    private String phone;
    @Nullable
    @Pattern(regexp = "[0-9]{2}:[0-9]{2}")
    private String hour;
}


