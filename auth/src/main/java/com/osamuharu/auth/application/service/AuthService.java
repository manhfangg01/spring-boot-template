package com.osamuharu.auth.application.service;

import com.osamuharu.auth.application.mapper.AuthMapper;
import com.osamuharu.auth.application.usecase.RegisterUseCase;
import com.osamuharu.auth.presentation.dto.RegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final RegisterUseCase registerUseCase;
  private final AuthMapper mapper;

  public void register(RegisterDto dto) {
    registerUseCase.execute(mapper.toDomain(dto));
  }
}
