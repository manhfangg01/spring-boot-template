package com.osamuharu.auth.application.service;

import com.osamuharu.auth.application.mapper.AuthMapper;
import com.osamuharu.auth.application.usecase.LoginUseCase;
import com.osamuharu.auth.application.usecase.RegisterUseCase;
import com.osamuharu.auth.presentation.dto.request.LoginRequestDto;
import com.osamuharu.auth.presentation.dto.request.RegisterRequestDto;
import com.osamuharu.auth.presentation.dto.response.LoginResponseDto;
import com.osamuharu.shared.entity.Subject;
import com.osamuharu.shared.entity.Token;
import com.osamuharu.shared.provider.TokenProvider;
import com.osamuharu.user.domain.entity.User;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final RegisterUseCase registerUseCase;
  private final LoginUseCase loginUseCase;
  private final AuthMapper mapper;
  private final TokenProvider tokenProvider;

  public void register(RegisterRequestDto dto) {
    registerUseCase.execute(mapper.toDomain(dto));
  }

  public LoginResponseDto login(LoginRequestDto dto) {
    User user = loginUseCase.execute(dto);

    Subject subject = Subject.builder()
        .username(user.getUsername())
        .build();

    List<Token> tokens = new ArrayList<>();

    Token accessToken = tokenProvider.generateAccessToken(subject);

    tokens.add(accessToken);

    return mapper.toDto(user, tokens, "Bearer");
  }
}
