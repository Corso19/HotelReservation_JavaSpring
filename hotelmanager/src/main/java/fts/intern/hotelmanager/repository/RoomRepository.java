package fts.intern.hotelmanager.repository;

import fts.intern.hotelmanager.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long>{
    @Query("SELECT r FROM Room r WHERE r.is_available = true")
    List<Room> findAllByIsAvailable();
}
