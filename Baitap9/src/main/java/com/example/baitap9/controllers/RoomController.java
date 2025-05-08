package com.example.baitap9.controllers;

import com.example.baitap9.models.ReposeObject;
import com.example.baitap9.models.Room;
import com.example.baitap9.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Rooms/")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping("/insertRoom")
    public ResponseEntity<ReposeObject> insertRoom(@RequestBody Room room) {
        List<Room> roomList = roomService.findRoomByRoomNumber(room.getRoomNumber());
        if(roomList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ReposeObject("Ok","Room number successly",roomService.save(room))
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new ReposeObject("false","Can not insert Room","")
        );
    }
    @PutMapping("/updateRoom/{roomNumber}")
    public ResponseEntity<ReposeObject> updateRoom(@PathVariable String roomNumber, @RequestBody Room newRoom) {
        List<Room> roomList = roomService.findRoomByRoomNumber(roomNumber);
        if(roomList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ReposeObject("false","Room number not found","")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ReposeObject("OK","Update Room successfully",  roomService.update(roomList.get(0), newRoom))
        );
    }
    @DeleteMapping("/deleteRoom/{roomNumber}")
    public ResponseEntity<ReposeObject> deleteRoom(@PathVariable String roomNumber) {
        List<Room> roomList = roomService.delete(roomNumber);
        if(roomList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ReposeObject("false","Room number not found","")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ReposeObject("OK","Delete Room successfully",  roomList)
        );
    }

    @GetMapping("/searchRoom")
    public ResponseEntity<ReposeObject> searchRoom(@RequestParam String roomNumber) {
        List<Room> roomList = roomService.searchRoomByRoomNumber(roomNumber);
        if(roomList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ReposeObject("false","Not find room","")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ReposeObject("OK","Search Room successfully",  roomList)
        );
    }
}
