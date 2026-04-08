package com.osamuharu.shared.provider;

import com.osamuharu.shared.entity.Subject;
import com.osamuharu.shared.entity.Token;

public interface TokenProvider {

  Token generateAccessToken(Subject subject);

  String extractUsername(String token);

  boolean validateToken(String token);
}
