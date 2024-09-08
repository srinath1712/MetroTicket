package com.BookingSystem.MetroTicket.Repository;

import com.BookingSystem.MetroTicket.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Optional<Ticket> findByTicketId(String ticketId);
}
