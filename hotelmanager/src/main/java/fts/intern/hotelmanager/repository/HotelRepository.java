package fts.intern.hotelmanager.repository;

import fts.intern.hotelmanager.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long>{
    List<Hotel> findByLatitudeBetweenAndLongitudeBetween(double minLatitude, double maxLatitude, double minLongitude, double maxLongitude);
}
