package com.omega.arjan.core.auth.identity;

import lombok.Data;

@Data
public class Secret {
  String hashString;
  HashType hashType;
}
