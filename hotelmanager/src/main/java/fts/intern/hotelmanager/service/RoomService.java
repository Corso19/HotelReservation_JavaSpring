package fts.intern.hotelmanager.service;

import fts.intern.hotelmanager.dto.RoomDto;
import fts.intern.hotelmanager.model.Room;
import fts.intern.hotelmanager.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<RoomDto> getAllRooms() {
        return roomRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private RoomDto convertToDto(Room room) {
        RoomDto dto = new RoomDto();
        // set fields as necessary
        return dto;
    }
}