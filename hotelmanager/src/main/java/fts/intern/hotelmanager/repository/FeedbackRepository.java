package fts.intern.hotelmanager.repository;

import fts.intern.hotelmanager.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long>{
}
