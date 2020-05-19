package com.omega.arjan.core.auth.authenticate;

public interface AuthenticationContext {
  AuthenticationStatus getStatus();
  Session getSession();



}
