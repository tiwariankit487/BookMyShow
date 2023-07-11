package com.scaler.bookmyshowjune2023.repositories;

import com.scaler.bookmyshowjune2023.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
Ticket save(Ticket ticket);
}
