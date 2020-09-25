package workers;

import activities.OTPActivityImpl;
import activities.ValidateUserActivityImpl;
import com.uber.cadence.worker.Worker;
import com.uber.cadence.worker.Worker.Factory;
import models.Constants;
import workflows.UserRegistrationWorkflow;
import workflows.UserRegistrationWorkflowImpl;

public class UserRegistrationWorker {

  public static void main(String[] args) {
    Worker.Factory factory = new Factory(Constants.DOMAIN);
    final Worker workerForUserRegistrationTaskList = factory.newWorker(Constants.USER_REGISTRATION_TASKLIST);
    workerForUserRegistrationTaskList.registerWorkflowImplementationTypes((UserRegistrationWorkflowImpl.class));
    workerForUserRegistrationTaskList.registerActivitiesImplementations(new ValidateUserActivityImpl(),new OTPActivityImpl());
    System.out.println("INFO : Starting worker for user registration");
    factory.start();
    System.out.println("INFO : Workflow started for task list " + Constants.USER_REGISTRATION_TASKLIST);

  }

}
