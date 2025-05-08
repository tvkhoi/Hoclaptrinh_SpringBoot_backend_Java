package com.example.baitap9.reponsitories;

import com.example.baitap9.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findRoomByRoomNumber(String roomNumber);

    void deleteByRoomNumber(String roomNumber);
    List<Room> findRoomByRoomNumberContaining(String roomNumber);
}
