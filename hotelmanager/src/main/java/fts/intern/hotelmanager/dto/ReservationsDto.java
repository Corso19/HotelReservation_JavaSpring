package fts.intern.hotelmanager.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationsDto {
    private Long id;
    private Long room_id;
    private String startDate;
    private String endDate;
}
