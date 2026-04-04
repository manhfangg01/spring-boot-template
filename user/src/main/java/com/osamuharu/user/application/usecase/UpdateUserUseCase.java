package com.osamuharu.user.application.usecase;

import com.osamuharu.user.domain.entity.User;
import com.osamuharu.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateUserUseCase {
	private final UserRepository repository;
	
	public User execute(Long id, User user) {
		if (user == null) {
			return null;
		}
		
		User existsUser = repository.findById(id)
		                            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
		
		if (user.getFirstName() != null) {
			existsUser.changeFirstName(user.getFirstName());
		}
		
		if (user.getLastName() != null) {
			existsUser.changeLastName(user.getLastName());
		}
		
		if (user.getEmail() != null && !existsUser.getEmail()
		                                          .equals(user.getEmail())) {
			if (repository.existsEmail(user.getEmail())) {
				throw new IllegalArgumentException("Email already exists: " + user.getEmail());
			}
			
			existsUser.changeEmail(user.getEmail());
		}
		
		if (user.getUsername() != null && !existsUser.getUsername()
		                                             .equals(user.getUsername())) {
			if (repository.existsByUsername(user.getUsername())) {
				throw new IllegalArgumentException("Username already exists: " + user.getUsername());
			}
			existsUser.changeUsername(user.getUsername());
		}
		
		return repository.save(existsUser);
	}
}
