package com.unittesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unittesting.dto.UserDto;
import com.unittesting.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping()
	public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
		UserDto saveUser = this.userService.saveUser(userDto);
		return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable Integer id, @RequestBody UserDto userDto) {
		UserDto updateUser = this.userService.updateUser(id, userDto);
		return new ResponseEntity<>(updateUser, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
		this.userService.deleteUser(id);
		return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer id) {
		UserDto user = this.userService.getUserById(id);
		return new ResponseEntity<>(user, HttpStatus.FOUND);
	}

	@GetMapping()
	public ResponseEntity<List<UserDto>> getUsers() {
		List<UserDto> users = this.userService.getAll();
		return new ResponseEntity<>(users, HttpStatus.FOUND);
	}

}
