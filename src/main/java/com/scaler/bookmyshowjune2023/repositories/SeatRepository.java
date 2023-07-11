package com.scaler.bookmyshowjune2023.repositories;

import com.scaler.bookmyshowjune2023.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends CrudRepository<Seat, Long> {
    List<Seat> findAllById(List<Long> seatIds);
}
