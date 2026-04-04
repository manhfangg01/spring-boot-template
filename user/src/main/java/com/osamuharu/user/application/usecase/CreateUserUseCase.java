package com.osamuharu.user.application.usecase;

import com.osamuharu.user.domain.entity.User;
import com.osamuharu.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateUserUseCase {
	private final UserRepository repository;
	
	public User execute(User user) {
		if (user == null) {
			throw new IllegalArgumentException("User cannot be null");
		}
		
		if (repository.existsEmail(user.getEmail())) {
			throw new IllegalArgumentException("Email already exists: " + user.getEmail());
		}
		
		if (repository.existsByUsername(user.getUsername())) {
			throw new IllegalArgumentException("Username already exists: " + user.getUsername());
		}
		
		return repository.save(user);
	}
}
