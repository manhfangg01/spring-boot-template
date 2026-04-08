package com.osamuharu.auth.application.usecase;

import com.osamuharu.user.application.usecase.CreateUserUseCase;
import com.osamuharu.user.domain.entity.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegisterUseCase {

  private final CreateUserUseCase createUserUseCase;

  public void execute(User user) {
    createUserUseCase.execute(user);
  }
}
