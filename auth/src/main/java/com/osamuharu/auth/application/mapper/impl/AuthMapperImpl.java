package com.osamuharu.auth.application.mapper.impl;

import com.osamuharu.auth.application.mapper.AuthMapper;
import com.osamuharu.auth.presentation.dto.RegisterDto;
import com.osamuharu.user.domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public class AuthMapperImpl implements AuthMapper {

  @Override
  public User toDomain(RegisterDto registerDto) {
    if (registerDto == null) {
      return null;
    }

    return User.builder()
        .firstName(registerDto.getFirstName())
        .lastName(registerDto.getLastName())
        .username(registerDto.getUsername())
        .email(registerDto.getEmail())
        .password(registerDto.getPassword())
        .build();
  }
}
