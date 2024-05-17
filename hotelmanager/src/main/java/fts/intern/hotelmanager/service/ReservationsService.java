package fts.intern.hotelmanager.service;

import fts.intern.hotelmanager.repository.ReservationsRepository;
import fts.intern.hotelmanager.dto.ReservationsDto;
import fts.intern.hotelmanager.model.Reservations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationsService {

    private final ReservationsRepository reservationsRepository;

    public ReservationsService(ReservationsRepository reservationsRepository) {
        this.reservationsRepository = reservationsRepository;
    }

    public List<ReservationsDto> getAllReservations() {
        return reservationsRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private ReservationsDto convertToDto(Reservations reservations) {
        ReservationsDto dto = new ReservationsDto();
        // set fields as necessary
        return dto;
    }
}