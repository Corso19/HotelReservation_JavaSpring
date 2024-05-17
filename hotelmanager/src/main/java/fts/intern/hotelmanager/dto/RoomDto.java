package fts.intern.hotelmanager.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomDto {
    private Integer roomNumber;
    private Integer hotelId;
    private Integer type;
    private int price;
    private Boolean isAvailable;
}