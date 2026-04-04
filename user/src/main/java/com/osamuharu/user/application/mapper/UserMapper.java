package com.osamuharu.user.application.mapper;


import com.osamuharu.user.domain.entity.User;
import com.osamuharu.user.infrastructure.persistence.entity.UserEntity;
import com.osamuharu.user.presentation.dto.request.CreateUserDto;
import com.osamuharu.user.presentation.dto.request.UpdateUserDto;
import com.osamuharu.user.presentation.dto.response.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
	User toDomain(UserEntity userEntity);
	
	User toDomain(CreateUserDto userDto);
	
	User toDomain(UpdateUserDto updateUserDto);
	
	UserDto toDto(User user);
	
	UserEntity toEntity(User user);
}

