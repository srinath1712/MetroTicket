package com.BookingSystem.MetroTicket.Repository;

import com.BookingSystem.MetroTicket.Model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Long> {
    Station findByName(String name);
}
