package uz.pdp.appgitproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appgitproject.entity.Hotel;
import uz.pdp.appgitproject.entity.Room;
import uz.pdp.appgitproject.payload.RoomDto;
import uz.pdp.appgitproject.repository.HotelRepository;
import uz.pdp.appgitproject.repository.RoomRepository;

import java.util.Optional;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    HotelRepository hotelRepository;

    @PostMapping
    public String add(@RequestBody RoomDto roomDto) {
        Room room = new Room();
        room.setNumber(roomDto.getNumber());
        room.setFloor(roomDto.getFloor());
        room.setSize(roomDto.getSize());
        Optional<Hotel> optionalHotel = hotelRepository.findById(roomDto.getHotelId());
        room.setHotel(optionalHotel.get());
        roomRepository.save(room);
        return "Room added;";
    }
    @GetMapping("/{hotelId}")
    public Page<Room> getRoomListByHotelId(@PathVariable Integer hotelId, @RequestParam int page){
        Pageable pageable = PageRequest.of(page,5);
        Page<Room> byHotelId = roomRepository.findAllByHotelId(hotelId, pageable);
        return byHotelId;

    }

}
