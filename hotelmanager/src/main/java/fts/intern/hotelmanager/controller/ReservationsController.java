package fts.intern.hotelmanager.controller;

import fts.intern.hotelmanager.dto.ReservationsDto;
import fts.intern.hotelmanager.service.ReservationsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationsController {

    private final ReservationsService reservationsService;

    public ReservationsController(ReservationsService reservationsService) {
        this.reservationsService = reservationsService;
    }

    @GetMapping
    public ResponseEntity<List<ReservationsDto>> getAllReservations() {
        return ResponseEntity.ok(reservationsService.getAllReservations());
    }

    // Add other endpoints as needed
}