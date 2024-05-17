package fts.intern.hotelmanager.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelDto {
    private int id;
    private String name;
    private double latitude;
    private double longitude;
}