package fts.intern.hotelmanager.service;

import fts.intern.hotelmanager.dto.HotelDto;
import fts.intern.hotelmanager.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<HotelDto> getAllHotels() {
        // Fetch all hotels from the repository, convert them to DTOs and return
        return null;
    }

    // Add other methods as needed
}