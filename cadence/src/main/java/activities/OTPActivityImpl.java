package activities;

import java.util.Random;
import java.util.UUID;

public class OTPActivityImpl implements OTPActivity {

  @Override
  public String sendOTP(String id, String type) {
    System.out.println("**** creating a new code 123456");
    return "123456";
  }

  @Override
  public Boolean verifyOTP(String wfCode, String userCode) {
    if(wfCode.equals(userCode)) {
      return true;
    }
    return false;
  }
}
