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
    MessageCli.REVIEW_ENTRY_HEADER.printMessage(
      Integer.toString(this.rating),
      "5",
      "Expert",
      this.reviewId,
      this.name
    );
    MessageCli.REVIEW_ENTRY_REVIEW_TEXT.printMessage(this.comment);
    if (this.recommended) {
      MessageCli.REVIEW_ENTRY_RECOMMENDED.printMessage();
    }
    if (!this.image.equals("")) {
      MessageCli.REVIEW_ENTRY_IMAGES.printMessage(this.image);
    }
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
