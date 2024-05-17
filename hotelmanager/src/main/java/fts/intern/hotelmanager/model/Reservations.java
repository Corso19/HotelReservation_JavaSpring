package fts.intern.hotelmanager.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reservationId;

    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    private Room room;
}