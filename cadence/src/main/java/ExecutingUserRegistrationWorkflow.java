import com.uber.cadence.WorkflowExecution;
import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.workflow.Workflow;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.Optional;
import java.util.Scanner;
import models.Constants;
import workflows.UserRegistrationWorkflow;

public class ExecutingUserRegistrationWorkflow {

  public static void main(String[] args) {
    WorkflowClient workflowClient = WorkflowClient.newInstance(Constants.DOMAIN);
    UserRegistrationWorkflow userRegistrationWorkflow = workflowClient.newWorkflowStub(UserRegistrationWorkflow.class);
    String inputString = "userId,User@1234,emailId,anunay.sinha@cad.ub.com";
    if(LocalDateTime.now().getSecond() %2 == 0) {
      //inputString = "userId,anunay123,emailId,anunay.sinha@cad.ub.com";
    }
    System.out.println("Execution started");
    WorkflowExecution workflowExecution = WorkflowClient.start(userRegistrationWorkflow::registerUser, inputString);
    System.out.println("Execution done");
    Scanner sc= new Scanner(System.in);
    System.out.println("Enter otp");
    String otp = sc.next();
    System.out.println("otp entered :"+ otp);
    //userRegistrationWorkflow = (UserRegistrationWorkflow) workflowClient.newUntypedWorkflowStub(workflowExecution, Optional.empty());
    userRegistrationWorkflow.onOTP(otp);
    sc.next();
    System.out.println("exit");


  }
}
