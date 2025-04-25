package nz.ac.auckland.se281;

import java.util.ArrayList;

public class ExpertReview extends Review {
  private boolean recommended;
  private ArrayList<String> images;

  public ExpertReview(
      Activity activity, String name, Integer rating, String comment, boolean recommended) {
    super(activity, name, rating, comment);
    this.recommended = recommended;
    this.images = new ArrayList<String>();
  }

  public void printEntry() {
    MessageCli.REVIEW_ENTRY_HEADER.printMessage(
        Integer.toString(this.rating), "5", "Expert", this.reviewId, this.name);
    MessageCli.REVIEW_ENTRY_REVIEW_TEXT.printMessage(this.comment);
    if (this.recommended) {
      MessageCli.REVIEW_ENTRY_RECOMMENDED.printMessage();
    }
    if (this.images.size() > 0) {
      String imageListString = this.images.get(0);
      for (int i = 1; i < this.images.size(); i++) {
        imageListString = imageListString + "," + this.images.get(i);
      }
      MessageCli.REVIEW_ENTRY_IMAGES.printMessage(imageListString);
    }
  }

  public boolean isRecommended() {
    return recommended;
  }

  public void setRecommended(boolean recommended) {
    this.recommended = recommended;
  }

  public ArrayList<String> getImages() {
    return images;
  }

  public void setImages(ArrayList<String> images) {
    this.images = images;
  }
}
