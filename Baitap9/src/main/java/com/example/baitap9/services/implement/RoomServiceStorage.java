package com.example.baitap9.services.implement;

import com.example.baitap9.models.Room;

import java.util.List;

public interface RoomServiceStorage {
    public Object save(Room room);
    List<Room> findRoomByRoomNumber(String roomNumber);
    public List<Room> update(Room oldRoom, Room newRoom);
    public List<Room> delete(String roomNumber);

    List<Room> searchRoomByRoomNumber(String roomNumber);
}
