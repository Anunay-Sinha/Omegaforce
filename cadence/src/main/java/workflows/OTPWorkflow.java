package workflows;

import com.uber.cadence.workflow.WorkflowMethod;

public interface OTPWorkflow {
  @WorkflowMethod(executionStartToCloseTimeoutSeconds = 10)
  Boolean handleOTP(String id, String type);
}
