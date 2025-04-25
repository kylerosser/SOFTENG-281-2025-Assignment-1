package nz.ac.auckland.se281;

public class PrivateReview extends Review {
  private String email;

  public PrivateReview(
    Activity activity, 
    String name, 
    Integer rating, 
    String comment,
    String email
  ) {
    super(activity, name, rating, comment);
    this.email = email;
  }
  
  public String printEntry() {
    return "";
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
}
