package fts.intern.hotelmanager.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomDto {
    private Long id;
    private Integer number;
    private Integer type;
    private int price;
    private Boolean isAvailable;
}