package com.example.baitap9.services;

import com.example.baitap9.models.Room;
import com.example.baitap9.reponsitories.RoomRepository;
import com.example.baitap9.services.implement.RoomServiceStorage;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements RoomServiceStorage {
    private RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    @Override
    public Object save(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public List<Room> findRoomByRoomNumber(String roomNumber) {
        return roomRepository.findRoomByRoomNumber(roomNumber);
    }

    @Override
    public List<Room> update(Room oldRoom, Room newRoom) {
        oldRoom.setRoomNumber(newRoom.getRoomNumber());
        oldRoom.setType(newRoom.getType());
        oldRoom.setPrice(newRoom.getPrice());
        oldRoom.setStatus(newRoom.getStatus());
        roomRepository.save(oldRoom);
        return roomRepository.findAll();
    }

    @Transactional
    @Override
    public List<Room> delete(String roomNumber) {
        List<Room> rooms = roomRepository.findRoomByRoomNumber(roomNumber);
        if(!rooms.isEmpty()) {
            roomRepository.deleteByRoomNumber(roomNumber);
        }
        return rooms;
    }
    @Override
    public List<Room> searchRoomByRoomNumber(String roomNumber) {
        return roomRepository.findRoomByRoomNumber(roomNumber);
    }
}
