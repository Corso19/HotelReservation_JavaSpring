package fts.intern.hotelmanager.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FeedbackDto {
    private Long id;
    private Long hotel_id;
    private Double rating;
    private String comment;

}

