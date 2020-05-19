package com.omega.arjan.core.auth.identity;

import lombok.Data;

@Data
public class UserSecret {
  String userId;
  Secret secret;
}
