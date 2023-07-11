package com.scaler.bookmyshowjune2023.repositories;

import com.scaler.bookmyshowjune2023.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long aLong);
    User save(User user);
}
