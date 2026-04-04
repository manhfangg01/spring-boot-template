package com.osamuharu.user.application.mapper.impl;

import com.osamuharu.user.application.mapper.UserMapper;
import com.osamuharu.user.domain.entity.User;
import com.osamuharu.user.infrastructure.persistence.entity.UserEntity;
import com.osamuharu.user.presentation.dto.request.CreateUserDto;
import com.osamuharu.user.presentation.dto.request.UpdateUserDto;
import com.osamuharu.user.presentation.dto.response.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
	@Override
	public User toDomain(UserEntity userEntity) {
		if (userEntity == null) {
			return null;
		}
		
		return User.builder()
		           .id(userEntity.getId())
		           .username(userEntity.getUsername())
		           .firstName(userEntity.getFirstName())
		           .lastName(userEntity.getLastName())
		           .email(userEntity.getEmail())
		           .password(userEntity.getPassword())
		           .build();
	}
	
	@Override
	public User toDomain(CreateUserDto userDto) {
		if (userDto == null) {
			return null;
		}
		
		return User.builder()
		           .username(userDto.getUsername())
		           .firstName(userDto.getFirstName())
		           .lastName(userDto.getLastName())
		           .email(userDto.getEmail())
		           .password(userDto.getPassword())
		           .build();
	}
	
	@Override
	public User toDomain(UpdateUserDto updateUserDto) {
		if (updateUserDto == null) {
			return null;
		}
		
		return User.builder()
		           .username(updateUserDto.getUsername())
		           .firstName(updateUserDto.getFirstName())
		           .lastName(updateUserDto.getLastName())
		           .email(updateUserDto.getEmail())
		           .password(updateUserDto.getPassword())
		           .build();
	}
	
	@Override
	public UserDto toDto(User user) {
		if (user == null) {
			return null;
		}
		
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setUsername(user.getUsername());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setEmail(user.getEmail());
		
		return userDto;
	}
	
	@Override
	public UserEntity toEntity(User user) {
		if (user == null) {
			return null;
		}
		
		UserEntity userEntity = new UserEntity();
		userEntity.setId(user.getId());
		userEntity.setUsername(user.getUsername());
		userEntity.setFirstName(user.getFirstName());
		userEntity.setLastName(user.getLastName());
		userEntity.setEmail(user.getEmail());
		userEntity.setPassword(user.getPassword());
		
		return userEntity;
	}
}
