package nz.ac.auckland.se281;

public class PrivateReview extends Review {
  private String email;
  private boolean followupRequested;
  private String followupResponse;
  private boolean resolved;

  public PrivateReview(
      Activity activity,
      String name,
      Integer rating,
      String comment,
      String email,
      boolean followupRequested) {
    super(activity, name, rating, comment);
    this.email = email;
    this.followupRequested = followupRequested;
    this.followupResponse = "";
    this.resolved = false;
  }

  public void printEntry() {
    MessageCli.REVIEW_ENTRY_HEADER.printMessage(
        Integer.toString(this.rating), "5", "Private", this.reviewId, this.name);
    MessageCli.REVIEW_ENTRY_REVIEW_TEXT.printMessage(this.comment);
    if (this.followupRequested) {
      if (this.resolved) {
        MessageCli.REVIEW_ENTRY_RESOLVED.printMessage(this.followupResponse);
      } else {
        MessageCli.REVIEW_ENTRY_FOLLOW_UP.printMessage(this.email);
      }
    } else {
      MessageCli.REVIEW_ENTRY_RESOLVED.printMessage("-");
    }
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

  public String getFollowupResponse() {
    return followupResponse;
  }

  public void setFollowupResponse(String followupResponse) {
    this.followupResponse = followupResponse;
  }

  public boolean isResolved() {
    return resolved;
  }

  public void setResolved(boolean resolved) {
    this.resolved = resolved;
  }
}
