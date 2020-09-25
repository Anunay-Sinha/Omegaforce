package com.omega.arjan.core.auth.authenticate;

import com.omega.arjan.core.auth.identity.MyUser;
import com.omega.arjan.core.auth.token.TokenProvider;

public interface UserSession {
  void setTokenProvider(TokenProvider tokenProvider);
  // ClientProvider
  // CredentialManager
  void closeSession();
  <T extends MyUser> T getUser();
  void addAttributes(String key, Object value);
  Object getAttributes(String key);
  Object removeAttributes(String key);

}
