package fts.intern.hotelmanager.repository;

import fts.intern.hotelmanager.model.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationsRepository extends JpaRepository<Reservations, Long>{
}
