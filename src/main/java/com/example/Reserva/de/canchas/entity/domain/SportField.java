package com.example.Reserva.de.canchas.entity.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Map;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SportField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Sport sport;
    @ElementCollection
    private Map<String, Boolean> availability;
    @OneToMany(mappedBy = "sportField")
    @JsonIgnore
    private Set<Reservation> reservations;

}
