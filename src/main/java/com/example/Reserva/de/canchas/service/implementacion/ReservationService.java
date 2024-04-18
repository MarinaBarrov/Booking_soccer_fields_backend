package com.example.Reserva.de.canchas.service.implementacion;

import com.example.Reserva.de.canchas.entity.domain.Reservation;
import com.example.Reserva.de.canchas.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService implements IService<Reservation> {


	@Override
	public Reservation findById(Integer id) {
		return null;
	}

	@Override
	public Reservation save(Reservation reservation) {
		return null;
	}

	@Override
	public void delete(Integer id) {

	}

	@Override
	public List<Reservation> listAll() {
		return null;
	}

	@Override
	public void update(Reservation reservation) {

	}
}
