package nz.ac.auckland.se281;

public class PrivateReview extends Review {
  private String email;
  private boolean followupRequested;

  public PrivateReview(
    Activity activity, 
    String name, 
    Integer rating, 
    String comment,
    String email,
    boolean followupRequested
  ) {
    super(activity, name, rating, comment);
    this.email = email;
    this.followupRequested = followupRequested;
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

  public boolean isFollowupRequested() {
    return followupRequested;
  }

  public void setFollowupRequested(boolean followupRequested) {
    this.followupRequested = followupRequested;
  }
  
}
