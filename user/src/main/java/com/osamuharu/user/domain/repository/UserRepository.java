package com.osamuharu.user.domain.repository;

import com.osamuharu.user.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
	User save(User user);
	
	void deleteById(Long id);
	
	List<User> findAll();
	
	Optional<User> findById(Long id);
	
	Optional<User> findByUsername(String username);
	
	boolean existsByUsername(String username);
	
	boolean existsEmail(String email);
	
	boolean existsById(Long id);
}
