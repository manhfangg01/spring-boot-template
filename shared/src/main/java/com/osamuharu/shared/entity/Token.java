package com.osamuharu.shared.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Token {

  private String token;
  private long expiresIn;
}
