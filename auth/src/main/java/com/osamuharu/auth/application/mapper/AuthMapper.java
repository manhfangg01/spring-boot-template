package com.osamuharu.auth.application.mapper;

import com.osamuharu.auth.presentation.dto.request.RegisterRequestDto;
import com.osamuharu.auth.presentation.dto.response.LoginResponseDto;
import com.osamuharu.shared.entity.Token;
import com.osamuharu.user.domain.entity.User;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthMapper {

  User toDomain(RegisterRequestDto registerRequestDto);

  LoginResponseDto toDto(User user, List<Token> token, String type);
}
