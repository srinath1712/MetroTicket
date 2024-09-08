package com.BookingSystem.MetroTicket.Controller;


import com.BookingSystem.MetroTicket.Model.Station;
import com.BookingSystem.MetroTicket.Repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/station")
@CrossOrigin(origins = "http://localhost:63342") // Allow requests from front-end
public class StationController {

    @Autowired
    StationRepository stationRepository;

    @GetMapping
    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }
    @GetMapping("/{stationName}")
    public Station getStation(@PathVariable String stationName){
        return stationRepository.findByName(stationName);
    }
}
