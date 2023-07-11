package com.scaler.bookmyshowjune2023.repositories;

import com.scaler.bookmyshowjune2023.models.Seat;
import com.scaler.bookmyshowjune2023.models.Show;
import com.scaler.bookmyshowjune2023.models.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {
   @Lock(LockModeType.WRITE)
List<ShowSeat> findAllBySeatInAndShow(List<Seat> seatList, Show show);
   ShowSeat save(ShowSeat showSeat);
}
