package com.BookingSystem.MetroTicket.Service;

import com.BookingSystem.MetroTicket.Model.Station;
import com.BookingSystem.MetroTicket.Repository.StationRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class StationService {

    @Autowired
    private StationRepository stationRepository;

    @PostConstruct
    public void initStations() {
        List<Station> stations = Arrays.asList(
                new Station("A", 0),
                new Station("B", 5),
                new Station("C", 15),
                new Station("D", 20),
                new Station("E", 25),
                new Station("F", 30),
                new Station("G", 35),
                new Station("H", 40),
                new Station("I", 45),
                new Station("J", 50),
                new Station("K", 55),
                new Station("L", 60),
                new Station("M", 65),
                new Station("N", 70),
                new Station("O", 75),
                new Station("P", 80),
                new Station("Q", 85),
                new Station("R", 90),
                new Station("S", 95),
                new Station("T", 100)
        );
        stationRepository.saveAll(stations);
    }
}
