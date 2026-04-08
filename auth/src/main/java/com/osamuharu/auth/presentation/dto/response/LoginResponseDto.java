package com.osamuharu.auth.presentation.dto.response;

import com.osamuharu.shared.entity.Token;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponseDto {

  String username;
  List<Token> tokens;
  String type = "Bearer";
}
