package com.unittesting.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unittesting.dto.UserDto;
import com.unittesting.entities.User;
import com.unittesting.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public UserDto saveUser(UserDto userDto) {
		User user = this.mapper.map(userDto, User.class);
		User savedUser = this.userRepository.save(user);
		return this.mapper.map(savedUser, UserDto.class);
	}

	@Override
	public UserDto updateUser(Integer id, UserDto userDto) {
		User user = this.userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		user.setName(userDto.getName());
		user.setCity(userDto.getCity());
		user.setAge(userDto.getAge());
		User updatedUser = this.userRepository.save(user);
		return this.mapper.map(updatedUser, UserDto.class);
	}

	@Override
	public void deleteUser(Integer id) {
		User user = this.userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		this.userRepository.delete(user);
	}

	@Override
	public UserDto getUserById(Integer id) {
		User user = this.userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		return this.mapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAll() {
		List<User> users = this.userRepository.findAll();
		List<UserDto> list = users.stream().map((user)-> this.mapper.map(user, UserDto.class)).collect(Collectors.toList());
		return list;
	}

}
