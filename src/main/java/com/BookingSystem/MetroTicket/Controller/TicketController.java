package com.BookingSystem.MetroTicket.Controller;
import com.BookingSystem.MetroTicket.Model.Ticket;
import com.BookingSystem.MetroTicket.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "http://localhost:63342")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/buy")
    public Ticket buyTicket(@RequestParam String startStation, @RequestParam String endStation) {
        return ticketService.bookTicket(startStation, endStation);
    }

    @PostMapping("/use/{ticketId}")
    public boolean useTicket(@PathVariable String ticketId) {
        return ticketService.useTicket(ticketId);
    }

    @GetMapping("/{ticketId}")
    public Ticket getTicket(@PathVariable String ticketId){
        return ticketService.getTicketUsingId(ticketId);
    }
}
