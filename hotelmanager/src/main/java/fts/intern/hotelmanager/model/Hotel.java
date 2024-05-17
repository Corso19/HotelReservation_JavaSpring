package fts.intern.hotelmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

import static jakarta.persistence.GenerationType.AUTO;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Hotel {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Integer id;
    private String name;
    private String address;
    private Double latitude;
    private Double longitude;
    @OneToMany
    private List<Room> rooms;
}
