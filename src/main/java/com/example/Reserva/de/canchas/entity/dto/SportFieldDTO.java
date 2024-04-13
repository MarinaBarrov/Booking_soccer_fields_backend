package com.example.Reserva.de.canchas.entity.dto;

import com.example.Reserva.de.canchas.entity.domain.Sport;
import jakarta.persistence.Entity;
import lombok.*;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SportFieldDTO {
    private String name;
    private Sport sport;
}
