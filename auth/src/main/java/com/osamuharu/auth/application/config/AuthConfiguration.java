package com.osamuharu.auth.application.config;

import com.osamuharu.auth.application.usecase.RegisterUseCase;
import com.osamuharu.user.application.usecase.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AuthConfiguration {

  private final CreateUserUseCase createUserUseCase;

  @Bean
  public RegisterUseCase registerUseCase() {
    return new RegisterUseCase(createUserUseCase);
  }
}
