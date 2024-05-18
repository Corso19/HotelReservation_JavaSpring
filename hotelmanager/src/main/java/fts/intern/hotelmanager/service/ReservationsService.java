package fts.intern.hotelmanager.service;

import fts.intern.hotelmanager.model.Room;
import fts.intern.hotelmanager.repository.ReservationsRepository;
import fts.intern.hotelmanager.dto.ReservationsDto;
import fts.intern.hotelmanager.model.Reservations;
import fts.intern.hotelmanager.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationsService {

    private final ReservationsRepository reservationsRepository;
    private final RoomRepository roomRepository;

    public ReservationsService(ReservationsRepository reservationsRepository, RoomRepository roomRepository) {
        this.reservationsRepository = reservationsRepository;
        this.roomRepository = roomRepository;
    }

    public List<ReservationsDto> getAllReservations() {
        return reservationsRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public ReservationsDto createReservation(ReservationsDto reservationsDto) {
        Reservations reservations = new Reservations();
        Room room = roomRepository.findById(reservationsDto.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found with id " + reservationsDto.getRoomId()));
        reservations.setRoom(room);
        reservations.setStartDate(reservationsDto.getStartDate());
        reservations.setEndDate(reservationsDto.getEndDate());
        reservations = reservationsRepository.save(reservations);
        return convertToDto(reservations);
    }

    private ReservationsDto convertToDto(Reservations reservations) {
        ReservationsDto dto = new ReservationsDto();
        dto.setId(reservations.getReservationId());
        dto.setRoomId(reservations.getRoom().getId());
//        dto.setRoomNumber(reservations.getRoom().getRoomNumber());
        dto.setStartDate(reservations.getStartDate());
        dto.setEndDate(reservations.getEndDate());
        return dto;
    }
}