package nz.ac.auckland.se281;

public class PublicReview extends Review {
  private boolean anonymous;
  private boolean endorsed;

  public PublicReview(
    Activity activity, 
    String name, 
    Integer rating, 
    String comment,
    boolean anonymous,
    boolean endorsed
  ) {
    super(activity, name, rating, comment);
    this.anonymous = anonymous;
    this.endorsed = endorsed;
  }

  public String printEntry() {
    return "";
  }

  public boolean isAnonymous() {
    return anonymous;
  }

  public void setAnonymous(boolean anonymous) {
    this.anonymous = anonymous;
  }

  public boolean isEndorsed() {
    return endorsed;
  }

  public void setEndorsed(boolean endorsed) {
    this.endorsed = endorsed;
  }

}
