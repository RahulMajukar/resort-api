package com.sanjeev.resort.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sanjeev.resort.models.Room;
import com.sanjeev.resort.repositories.RoomRepository;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

	@Autowired
	private RoomRepository roomRepository;

	@GetMapping
	public ResponseEntity<List<Room>> getAllRooms() {
		List<Room> rooms = roomRepository.findAll();
		return new ResponseEntity<>(rooms, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
		Room room = roomRepository.findById(id).orElse(null);
		if (room != null) {
			return new ResponseEntity<>(room, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Room> createRoom(@RequestBody Room room) {
		Room savedRoom = roomRepository.save(room);
		return new ResponseEntity<>(savedRoom, HttpStatus.CREATED);
	}

//    /api/rooms?sortByCapacity=capacity will return all rooms sorted by capacity.
//    /api/rooms?sortByPrice=price will return all rooms sorted by price.
//    /api/rooms?sortByCapacity=capacity&sortByPrice=price will return all rooms sorted first 
	@GetMapping("/sort")
	public ResponseEntity<List<Room>> getAllRooms(@RequestParam(required = false) String sortByCapacity,
			@RequestParam(required = false) String sortByPrice) {
		List<Room> rooms;

		if (sortByCapacity != null && sortByPrice != null) {
			rooms = roomRepository.findAll(Sort.by(Sort.Direction.ASC, sortByCapacity, sortByPrice));
		} else if (sortByCapacity != null) {
			rooms = roomRepository.findAll(Sort.by(Sort.Direction.ASC, sortByCapacity));
		} else if (sortByPrice != null) {
			rooms = roomRepository.findAll(Sort.by(Sort.Direction.ASC, sortByPrice));
		} else {
			rooms = roomRepository.findAll();
		}

		return new ResponseEntity<>(rooms, HttpStatus.OK);
	}

	// Similar methods for updating and deleting rooms can be added here
}
