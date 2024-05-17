package fts.intern.hotelmanager.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private int id;

    @Column(name = "username")
    private String username;

    @ManyToOne
    @JoinColumn(name = "fk_feedback_hotel_id", referencedColumnName = "id")
    private Hotel hotel;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "comment")
    private String comment;
}