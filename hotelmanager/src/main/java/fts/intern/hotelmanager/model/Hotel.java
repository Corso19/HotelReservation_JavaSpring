package fts.intern.hotelmanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.List;

import static jakarta.persistence.GenerationType.AUTO;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private String address;
    private Double latitude;
    private Double longitude;
    @OneToMany
    private List<Room> rooms;
}
