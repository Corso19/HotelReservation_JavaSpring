package fts.intern.hotelmanager.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReservationsDto {
    private Long id;
    private Integer roomNumber;
    private Integer hotelId;
    private LocalDate startDate;
    private LocalDate endDate;
}