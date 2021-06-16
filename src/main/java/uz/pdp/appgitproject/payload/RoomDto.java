package uz.pdp.appgitproject.payload;

import lombok.Data;

@Data
public class RoomDto {

    private Integer number;
    private String floor;
    private String size;
    private Integer hotelId;
}
