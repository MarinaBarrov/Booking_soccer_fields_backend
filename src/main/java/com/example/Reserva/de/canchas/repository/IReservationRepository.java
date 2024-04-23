package com.example.Reserva.de.canchas.repository;

import com.example.Reserva.de.canchas.entity.domain.Reservation;
import com.example.Reserva.de.canchas.entity.domain.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Integer>, JpaSpecificationExecutor<Reservation> {

    @Query("""
            SELECT r FROM Reservation r
            WHERE ((:sport IS NOT NULL AND r.sportField.sport = :sport)
                    OR (:sport IS NULL))
              AND ((:sportFieldName IS NOT NULL AND r.sportField.name = :sportFieldName)
                    OR (:sportFieldName IS NULL))
            """)
    List<Reservation> findByCriteria(@Param("sport") Sport sport, @Param("sportFieldName") String sportFieldName);
}
