package com.hotel.bookingmicroservice.feign;

import com.hotel.bookingmicroservice.model.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "ROOM-microservice")
public interface RoomClient {
    @GetMapping("/rooms/{roomId}")
    Room getRoomById(@PathVariable int roomId);
}
