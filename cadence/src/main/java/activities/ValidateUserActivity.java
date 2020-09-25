package activities;

import com.uber.cadence.activity.ActivityMethod;

public interface ValidateUserActivity {

  @ActivityMethod(scheduleToCloseTimeoutSeconds = 2)
  Boolean isUserAvailable(String id, String type);
}
