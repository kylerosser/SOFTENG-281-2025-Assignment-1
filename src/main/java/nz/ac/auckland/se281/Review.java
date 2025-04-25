package nz.ac.auckland.se281;

import java.util.ArrayList;

public abstract class Review {
  private Activity activity;
  private String reviewId;
  private String name;
  private Integer rating;
  private String comment;

  public Review(
    Activity activity, 
    String name, 
    Integer rating, 
    String comment
  ) {
    this.activity = activity;
    this.name = name;
    this.rating = rating;
    this.comment = comment;

    // Start generating review id
    this.reviewId = this.activity.getActivityId() + "-R";

    // Get the number of reviews in the activity
    ArrayList<Review> reviewList = this.activity.getReviewList();
    int reviewCount = reviewList.size();

    // Finish generating the review id
    this.reviewId = this.reviewId + Integer.toString(reviewCount + 1);
  }

  public Activity getActivity() {
    return activity;
  }

  public void setActivity(Activity activity) {
    this.activity = activity;
  }

  public String getReviewId() {
    return reviewId;
  }

  public void setReviewId(String reviewId) {
    this.reviewId = reviewId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public abstract String printEntry();

}
