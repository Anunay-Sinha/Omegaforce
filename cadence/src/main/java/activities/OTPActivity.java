package activities;

import com.uber.cadence.activity.ActivityMethod;

public interface OTPActivity {
  @ActivityMethod(scheduleToCloseTimeoutSeconds = 10)
  String sendOTP(String id, String type);
  @ActivityMethod(scheduleToCloseTimeoutSeconds = 10)
  Boolean verifyOTP(String wfCode, String userCode);
}
