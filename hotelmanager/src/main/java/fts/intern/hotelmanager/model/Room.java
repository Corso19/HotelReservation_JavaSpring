package fts.intern.hotelmanager.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @Column(name = "roomNumber")
    private Integer roomNumber;

    @Column(name = "type")
    private Integer type;

    @Column(name = "price")
    private int price;

    @Column(name = "isAvailable")
    private Boolean is_available;
}