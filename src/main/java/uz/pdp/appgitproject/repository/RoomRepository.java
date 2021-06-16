package uz.pdp.appgitproject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appgitproject.entity.Room;

public interface RoomRepository extends JpaRepository<Room,Integer> {

    Page<Room> findAllByHotelId(Integer hotel_id, Pageable pageable);
}
