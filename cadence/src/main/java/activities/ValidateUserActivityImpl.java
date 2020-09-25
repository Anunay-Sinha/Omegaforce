package activities;

public class ValidateUserActivityImpl implements ValidateUserActivity {

  @Override
  public Boolean isUserAvailable(String id, String type) {
    System.out.println("**** validating if user exist");
    if(id.startsWith("anu")) {
      System.out.println("**** id is available with us : "+id);
      return true;
    } else {
      System.out.println("**** id is not available with us : "+id);
      return false;
    }
  }
}
