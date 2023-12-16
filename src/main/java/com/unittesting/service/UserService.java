package com.unittesting.service;

import java.util.List;

import com.unittesting.dto.UserDto;

public interface UserService {

	public abstract UserDto saveUser(UserDto userDto);
	
	public abstract UserDto updateUser(Integer id, UserDto userDto);
	
	public abstract void deleteUser(Integer id);
	
	public abstract UserDto getUserById(Integer id);
	
	public abstract List<UserDto> getAll();
}
