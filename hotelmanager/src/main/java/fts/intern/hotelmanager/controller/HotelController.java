package fts.intern.hotelmanager.controller;

import fts.intern.hotelmanager.dto.HotelDto;
import fts.intern.hotelmanager.service.HotelService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public ResponseEntity<List<HotelDto>> getAllHotels() {
        double latitude = 46.763214;
        double longitude = 23.585467;

        double rangeInKm = 10.0;

        return ResponseEntity.ok(hotelService.getAllHotels(latitude, longitude, rangeInKm));
    }

    // Add other endpoints as needed
}