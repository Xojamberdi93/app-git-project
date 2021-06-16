package uz.pdp.appgitproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appgitproject.entity.Hotel;
import uz.pdp.appgitproject.repository.HotelRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelRepository hotelRepository;

    @GetMapping
    public List<Hotel> getAll() {
        List<Hotel> hotelList = hotelRepository.findAll();
        return hotelList;
    }

    @PostMapping
    public String add(@RequestBody Hotel hotel){
        Hotel hotel1 = new Hotel();
        hotel1.setName(hotel.getName());
        hotelRepository.save(hotel1);
        return "Hotel added";
    }

    @PutMapping("/{id}")
    public String edit(@PathVariable Integer id,@RequestBody Hotel hotel){
        Hotel hotel1 = hotelRepository.getById(id);
        hotel1.setName(hotel.getName());
        hotelRepository.save(hotel1);
        return "Hotel edited";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        if (!optionalHotel.isPresent())
            return "Hotel not found";
        hotelRepository.deleteById(id);
        return "Hotel deleted";
    }
}
