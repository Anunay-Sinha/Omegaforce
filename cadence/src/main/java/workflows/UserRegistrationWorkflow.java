package workflows;

import com.uber.cadence.workflow.SignalMethod;
import com.uber.cadence.workflow.WorkflowMethod;

public interface UserRegistrationWorkflow {

  @WorkflowMethod(taskList = "user-registration-v1", executionStartToCloseTimeoutSeconds = 30)
  Boolean registerUser(String csKVPairs);

  @SignalMethod
  void onOTP(String code);
}
