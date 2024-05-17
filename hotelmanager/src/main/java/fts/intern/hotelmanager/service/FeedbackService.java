package fts.intern.hotelmanager.service;

import fts.intern.hotelmanager.model.Feedback;
import fts.intern.hotelmanager.repository.FeedbackRepository;
import fts.intern.hotelmanager.dto.FeedbackDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public List<FeedbackDto> getAllFeedbacks() {
        return feedbackRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private FeedbackDto convertToDto(Feedback feedback) {
        FeedbackDto dto = new FeedbackDto();
        dto.setId(feedback.getId());
        dto.setHotel_id(feedback.getHotel_id());
        dto.setRating(feedback.getRating());
        dto.setComment(feedback.getComment());
        return dto;
    }
}