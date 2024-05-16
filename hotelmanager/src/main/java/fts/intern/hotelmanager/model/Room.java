package fts.intern.hotelmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Room {
    @Id
    private Integer id;
    private Integer number;
    private Integer type;
    private int price;
    private Boolean isAvailable;

}
