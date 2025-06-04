package com.hotel.room_microservice.service;

import com.hotel.room_microservice.model.Room;
import com.hotel.room_microservice.repository.RoomRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Optional<Room> getRoomById(int id) {
        return roomRepository.findById(id);
    }

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }
    public Room updateRoom(int id, Room updatedRoom) {
        Room existingRoom = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + id));

        existingRoom.setRoomType(updatedRoom.getRoomType());
        existingRoom.setNoOfBeds(updatedRoom.getNoOfBeds());
        existingRoom.setRoomStatus(updatedRoom.isRoomStatus());
        existingRoom.setRoomRent(updatedRoom.getRoomRent());

        return roomRepository.save(existingRoom);
    }

    public void deleteRoom(int id) {
         roomRepository.deleteById(id);
    }
}
