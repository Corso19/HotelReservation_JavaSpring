package fts.intern.hotelmanager.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedbackDto {
    private int id;
    private int hotel_id;
    private Double rating;
    private String comment;
}