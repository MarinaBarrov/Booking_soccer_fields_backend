package com.example.Reserva.de.canchas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Table(name = "canchas")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cancha {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long numeroCancha;
	private Integer cantJugadores;
	private Boolean techada;

}
