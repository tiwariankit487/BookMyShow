package com.scaler.bookmyshowjune2023.repositories;

import com.scaler.bookmyshowjune2023.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

    Optional<Show> findById(Long aLong);
}
