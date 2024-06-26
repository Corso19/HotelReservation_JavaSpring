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

    public List<RoomDto> getAvailableRooms() {
        List<Room> rooms = roomRepository.findAllByIsAvailable();
        return rooms.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private RoomDto convertToDto(Room room) {
        RoomDto dto = new RoomDto();
        dto.setRoomNumber(room.getRoomNumber());
        dto.setHotelId(room.getHotel().getId());
        dto.setType(room.getType());
        dto.setPrice(room.getPrice());
        dto.setIs_available(room.getIs_available());
        return dto;
    }
}