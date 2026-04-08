package com.osamuharu.shared.provider;

public interface PasswordProvider {

  String hashPassword(String password);

  boolean verifyPassword(String password, String hashedPassword);
}
