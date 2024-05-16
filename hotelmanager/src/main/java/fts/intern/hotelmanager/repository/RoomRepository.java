package fts.intern.hotelmanager.repository;

import fts.intern.hotelmanager.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long>{
}
