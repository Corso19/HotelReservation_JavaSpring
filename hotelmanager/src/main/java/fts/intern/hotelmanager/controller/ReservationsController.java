package fts.intern.hotelmanager.controller;

import fts.intern.hotelmanager.dto.ReservationsDto;
import fts.intern.hotelmanager.service.ReservationsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
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

    @PostMapping
    public ResponseEntity<ReservationsDto> createReservation(@RequestBody ReservationsDto reservationsDto) {
        return ResponseEntity.ok(reservationsService.createReservation(reservationsDto));
    }

    // Add other endpoints as needed
}