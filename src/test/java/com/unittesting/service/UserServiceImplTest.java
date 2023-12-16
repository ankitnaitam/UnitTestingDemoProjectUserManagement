package com.unittesting.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.unittesting.dto.UserDto;
import com.unittesting.entities.User;
import com.unittesting.repository.UserRepository;

@SpringBootTest
class UserServiceImplTest {

	@MockBean
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper mapper;

	User user;
	User user1;

	List<User> users;

	UserDto userDto;

	@BeforeEach
	public void init() {

		userDto = UserDto.builder().id(2).name("Virat").city("Dehli").age(34).build();

		user = User.builder().id(2).name("Jaddu").city("Mumbai").age(27).build();

		user1 = User.builder().id(3).name("Dhoni").city("Chennai").age(30).build();

		users = new ArrayList<>();
		users.add(user);
		users.add(user1);

	}

	@Test
	public void saveUser() {

		// arrange
		Mockito.when(userRepository.save(Mockito.any())).thenReturn(user);

		// Act
		UserDto saveUser = userService.saveUser(mapper.map(user, UserDto.class));

		// Assert
		Assertions.assertEquals("Jaddu", saveUser.getName());
	}

	@Test
	public void updateUser() {
		
		User updatedUser = User.builder().id(2).name("Virat").city("Dehli").age(34).build();
		UserDto updatedUserDto = UserDto.builder().id(2).name("Virat").city("Dehli").age(34).build();

//		User updatedUser = new User(2, "Virat", "Dehli", 34);
//		UserDto updatedUserDto = new UserDto(2, "Virat", "Dehli", 34);

		Mockito.when(userRepository.findById(2)).thenReturn(Optional.of(user));
		Mockito.when(userRepository.save(any(User.class))).thenReturn(updatedUser);

		Integer id = 2;
		UserDto result = userService.updateUser(id, userDto);

//		verify(userRepository,times(1)).findById(id);
//		verify(userRepository,times(1)).save(updatedUser);
		
		System.out.println(updatedUserDto.hashCode());
		System.out.println(result.hashCode());

		assertEquals(updatedUserDto.getCity(), result.getCity());
		assertEquals(updatedUserDto.getName(), result.getName());
		assertEquals(updatedUserDto.getAge(), result.getAge());

	}

}
