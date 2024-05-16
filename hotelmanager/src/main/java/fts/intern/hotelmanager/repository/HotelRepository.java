package fts.intern.hotelmanager.repository;

import fts.intern.hotelmanager.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long>{
}
