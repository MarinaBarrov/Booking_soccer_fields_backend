package com.example.Reserva.de.canchas.repository;


import com.example.Reserva.de.canchas.entity.domain.SportField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISportFieldRepository extends JpaRepository<SportField, Integer> {

    Optional<SportField> findByName(String name);


}
