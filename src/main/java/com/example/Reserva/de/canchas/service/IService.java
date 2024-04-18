package com.example.Reserva.de.canchas.service;

import java.util.List;

public interface IService<T> {


	T findById(Integer id);

	T save(T t);

	void delete(Integer id);

	List<T> listAll();

	void update(T t);


}
