package fts.intern.hotelmanager.service;

import fts.intern.hotelmanager.dto.HotelDto;
import fts.intern.hotelmanager.model.Hotel;
import fts.intern.hotelmanager.repository.HotelRepository;
import org.springframework.stereotype.Service;
import fts.intern.hotelmanager.utils.GeoLocationUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<HotelDto> getAllHotels(double latitude,double longitude,double rangeInKm) {

        var rangeValues = GeoLocationUtils.calculateSquareRange(latitude, longitude, rangeInKm);

        return hotelRepository.findByLatitudeBetweenAndLongitudeBetween(rangeValues[0][0], rangeValues[1][0], rangeValues[0][1], rangeValues[1][1])
                .stream()
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