package fts.intern.hotelmanager.dto;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReservationsDto {
    @Nullable
    private Long id;
    private Integer roomNumber;
//    private Integer hotelId;
    private Long roomId;
    private LocalDate startDate;
    private LocalDate endDate;
}