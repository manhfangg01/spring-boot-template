package com.osamuharu.user.unit;

import com.osamuharu.user.application.usecase.CreateUserUseCase;
import com.osamuharu.user.domain.entity.User;
import com.osamuharu.user.domain.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreateUserUseCaseTest {
	
	@Mock
	private UserRepository repository;
	
	static private User user;
	
	@InjectMocks
	private CreateUserUseCase createUserUseCase;
	
	@BeforeAll
	static void initAll() {
		user = User.builder()
		           .username("johndoe")
		           .firstName("John")
		           .lastName("Doe")
		           .email("johndoe@gmail.com")
		           .build();
	}
	
	@Test
	@DisplayName("execute() - when valid user is provided, should save and return the user")
	public void execute_WhenValidUser_ShouldSaveAndReturnUser() {
		when(repository.existsByEmail(user.getEmail())).thenReturn(false);
		when(repository.existsByUsername(user.getUsername())).thenReturn(false);
		when(repository.save(user)).thenReturn(user);
		
		User result = createUserUseCase.execute(user);
		
		assertNotNull(result);
		assertEquals(result, user);
		
		verify(repository, times(1)).existsByEmail(user.getEmail());
		verify(repository, times(1)).existsByUsername(user.getUsername());
		verify(repository, times(1)).save(user);
	}
	
	@Test
	@DisplayName("execute() - when user is null, throw IllegalArgumentException('User cannot be null')")
	public void execute_WhenInValidUser_ShouldSaveAndReturnUser() {
		IllegalArgumentException exception = assertThrows(
				IllegalArgumentException.class,
				() -> createUserUseCase.execute(null)
		);
		
		assertEquals("User cannot be null", exception.getMessage());
		
		verifyNoInteractions(repository);
	}
	
	@Test
	@DisplayName("execute() - when already exists email, throw IllegalArgumentException('Email already exists: + " +
			"email')")
	void execute_WhenEmailAlreadyExists_ShouldThrowException() {
		when(repository.existsByEmail(user.getEmail())).thenReturn(true);
		
		IllegalArgumentException exception = assertThrows(
				IllegalArgumentException.class,
				() -> createUserUseCase.execute(user)
		);
		
		assertEquals("Email already exists: " + user.getEmail(), exception.getMessage());
		
		verify(repository, never()).save(any(User.class));
	}
	
	@Test
	@DisplayName("execute() - when already exists username, throw IllegalArgumentException('Username already exists:" +
			" " + "+" + " " + "username')")
	void execute_WhenUsernameAlreadyExists_ShouldThrowException() {
		when(repository.existsByUsername(user.getUsername())).thenReturn(true);
		
		IllegalArgumentException exception = assertThrows(
				IllegalArgumentException.class,
				() -> createUserUseCase.execute(user)
		);
		
		assertEquals("Username already exists: " + user.getUsername(), exception.getMessage());
		
		verify(repository, never()).save(any(User.class));
	}
}
