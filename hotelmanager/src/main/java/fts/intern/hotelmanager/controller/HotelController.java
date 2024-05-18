package fts.intern.hotelmanager.controller;

import fts.intern.hotelmanager.dto.HotelDto;
import fts.intern.hotelmanager.service.HotelService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public ResponseEntity<List<HotelDto>> getAllHotels(@RequestParam(value = "latitude", required = false) Double latitude,
                                                       @RequestParam(value = "longitude", required = false) Double longitude,
                                                       @RequestParam(value = "rangeInKm", required = false) Double rangeInKm) {
        latitude = latitude != null ? latitude : 46.763214;
        longitude = longitude != null ? longitude : 23.585467;
        rangeInKm = rangeInKm != null ? rangeInKm : 1.0; // default values in case frontend falls apart as it usually does :(

        return ResponseEntity.ok(hotelService.getAllHotels(latitude, longitude, rangeInKm));
    }

    // Add other endpoints as needed
}