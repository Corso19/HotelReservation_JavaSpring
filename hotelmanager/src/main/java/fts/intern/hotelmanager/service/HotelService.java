package fts.intern.hotelmanager.service;

import fts.intern.hotelmanager.dto.HotelDto;
import fts.intern.hotelmanager.model.Hotel;
import fts.intern.hotelmanager.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<HotelDto> getAllHotels() {
        return hotelRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private HotelDto convertToDto(Hotel hotel) {
        HotelDto dto = new HotelDto();
        dto.setId(hotel.getId());
        dto.setName(hotel.getName());
        dto.setLatitude(hotel.getLatitude());
        dto.setLongitude(hotel.getLongitude());
        // set other fields as necessary
        return dto;
    }
}