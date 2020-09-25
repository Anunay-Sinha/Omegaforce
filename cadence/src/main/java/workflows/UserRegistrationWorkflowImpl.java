package workflows;

import activities.OTPActivity;
import activities.ValidateUserActivity;
import com.uber.cadence.workflow.Workflow;
import java.util.HashMap;
import java.util.Map;

public class UserRegistrationWorkflowImpl implements UserRegistrationWorkflow {

  private final ValidateUserActivity validateUserActivity = Workflow
      .newActivityStub(ValidateUserActivity.class);

  private final OTPActivity otpActivity = Workflow
      .newActivityStub(OTPActivity.class);

  String otpResponse = "NA";


  @Override
  public Boolean registerUser(String csKVPairs) {
    Map<String, String> argumentMap = getArguments(csKVPairs);

    if (argumentMap.containsKey("userId")) {
      String userId = argumentMap.get("userId");
      System.out.println("**** Registering user with user id " + userId);
      if (!validateUserActivity.isUserAvailable(userId, "EMAIL")) {
        System.out.println("**** Proceeding with OTP request");
        String otp = otpActivity.sendOTP(userId, "EMAIL");
        while (true) {
          System.out.println("**** Awaiting the response for OTP");
          Workflow.await(() -> !otpResponse.equals("NA"));
          System.out.println("**** Got the response for OTP " + otpResponse);
          if (otpActivity.verifyOTP(otp, otpResponse)) {
            System.out.println("**** OTP response is valid");
            return true;
          } else {
            System.out.println("**** OTP response is invalid");
            break;
          }

        }


      }
    }
    System.out.println("Error : Registration failed for the request");
    System.out.println("Error : Arguments " + csKVPairs);
    return false;

  }

  @Override
  public void onOTP(String code) {
    this.otpResponse = code;
  }

  private Map<String, String> getArguments(String csKVPairs) {
    HashMap<String, String> map = new HashMap();
    String[] pairs = csKVPairs.split(",");
    for (int i = 0; i < pairs.length; i = i + 2) {
      try {
        map.put(pairs[i], pairs[i + 1]);
      } catch (Exception ex) {
        System.out.println("Warn : KV pairs not matching " + ex.getMessage());
      }
    }
    return map;

  }
}
