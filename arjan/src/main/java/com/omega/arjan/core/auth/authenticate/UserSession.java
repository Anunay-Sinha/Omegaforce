package com.omega.arjan.core.auth.authenticate;


import com.omega.arjan.core.auth.identity.User;

public interface Session {
  // TokenManager
  // ClientProvider
  // CredentialManager
  // UserProvider
  void closeSession();
  <T extends User> T getUser();
  void addAttributes(String key, Object value);
  Object getAttributes(String key);
  Object removeAttributes(String key);

}
