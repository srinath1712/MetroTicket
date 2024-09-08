package com.BookingSystem.MetroTicket.Service;

import com.BookingSystem.MetroTicket.Model.Station;
import com.BookingSystem.MetroTicket.Model.Ticket;
import com.BookingSystem.MetroTicket.Repository.StationRepository;
import com.BookingSystem.MetroTicket.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private StationRepository stationRepository;

    public Ticket bookTicket(String startStationName, String endStationName) {
        Station startStation = stationRepository.findByName(startStationName);
        Station endStation = stationRepository.findByName(endStationName);
        int price = Math.abs(endStation.getPrice() - startStation.getPrice());
        Ticket ticket = new Ticket();
        ticket.setStartStation(startStation);
        ticket.setEndStation(endStation);
        ticket.setTicketId(UUID.randomUUID().toString());
        ticket.setCreatedAt(LocalDateTime.now());
        ticket.setExpiresAt(LocalDateTime.now().plusHours(18));
        ticket.setPrice(price);
        ticket.setUsageCount(0);
        return ticketRepository.save(ticket);
    }

    public boolean useTicket(String ticketId) {
        Ticket ticket = getTicketUsingId(ticketId);
        if (!ticket.canBeUsed()) {
            return false;
        }
        ticket.setUsageCount(ticket.getUsageCount() + 1);
        ticketRepository.save(ticket);
        return true;
    }

    public Ticket getTicketUsingId(String ticketId){
        return ticketRepository.findByTicketId(ticketId).orElseThrow(() -> new RuntimeException("Ticket not found"));
    }
}
