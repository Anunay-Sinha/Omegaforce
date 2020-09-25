package com.omega.arjan.core.auth.token;

public interface TokenProvider {
  Token getToken();
  void setSession();

}
