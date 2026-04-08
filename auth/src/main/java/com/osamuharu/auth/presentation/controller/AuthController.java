package com.osamuharu.auth.presentation.controller;

import com.osamuharu.auth.application.service.AuthService;
import com.osamuharu.auth.presentation.dto.RegisterDto;
import com.osamuharu.shared.annotation.ResponseMessage;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/{version}/auth", version = "v1")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @PostMapping("/register")
  @ResponseStatus(HttpStatus.CREATED)
  @ResponseMessage("Register successfully")
  public boolean register(@Valid @RequestBody RegisterDto dto) {
    authService.register(dto);
    return true;
  }
}
