package com.osamuharu.auth.application.mapper;

import com.osamuharu.auth.presentation.dto.RegisterDto;
import com.osamuharu.user.domain.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthMapper {

  User toDomain(RegisterDto registerDto);
}
