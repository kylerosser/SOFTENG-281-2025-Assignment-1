package nz.ac.auckland.se281;

public class ExpertReview extends Review {
  private boolean recommended;
  private String image;

  public ExpertReview(
    Activity activity, 
    String name, 
    Integer rating, 
    String comment,
    boolean recommended,
    String image
  ) {
    super(activity, name, rating, comment);
    this.recommended = recommended;
    this.image = image;
  }
  
  public void printEntry() {
    
  }

  public boolean isRecommended() {
    return recommended;
  }

  public void setRecommended(boolean recommended) {
    this.recommended = recommended;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }
  
}
