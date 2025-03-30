package nz.ac.auckland.se281;

import java.util.ArrayList;

public class OperatorManagementSystem {

  // Do not change the parameters of the constructor
  public OperatorManagementSystem() {}

  public ArrayList<Operator> operators = new ArrayList<Operator>();

  public void searchOperators(String keyword) {
    if (this.operators.size() == 0) {
      MessageCli.CUSTOM.printMessage("There are no matching operators found.");
      return;
    }
  }

  public void createOperator(String operatorName, String location) {

    Types.Location locationToAssign = null;

    for (Types.Location thisLocation : Types.Location.values()) {
      if (thisLocation.getLocationAbbreviation().toLowerCase().equals(location.strip().toLowerCase())) {
        locationToAssign = thisLocation;
      }
    }
    if (locationToAssign == null) {
      MessageCli.OPERATOR_NOT_CREATED_INVALID_LOCATION.printMessage(location);
      return;
    }

    Operator newOperator = new Operator(operatorName, locationToAssign, "PLACEHOLDER");
    operators.add(newOperator);
    MessageCli.OPERATOR_CREATED.printMessage(operatorName, "PLACEHOLDER", locationToAssign.getFullName());
  }

  public void viewActivities(String operatorId) {
    // TODO implement
  }

  public void createActivity(String activityName, String activityType, String operatorId) {
    // TODO implement
  }

  public void searchActivities(String keyword) {
    // TODO implement
  }

  public void addPublicReview(String activityId, String[] options) {
    // TODO implement
  }

  public void addPrivateReview(String activityId, String[] options) {
    // TODO implement
  }

  public void addExpertReview(String activityId, String[] options) {
    // TODO implement
  }

  public void displayReviews(String activityId) {
    // TODO implement
  }

  public void endorseReview(String reviewId) {
    // TODO implement
  }

  public void resolveReview(String reviewId, String response) {
    // TODO implement
  }

  public void uploadReviewImage(String reviewId, String imageName) {
    // TODO implement
  }

  public void displayTopActivities() {
    // TODO implement
  }
}
