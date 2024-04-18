package com.example.Reserva.de.canchas.entity.domain;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellido;
	private String dni;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "Client")
	private Set<Reservation> reservations;


}
