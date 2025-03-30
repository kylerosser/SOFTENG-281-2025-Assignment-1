package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Types.Location;

public class OperatorManagementSystem {

  // Do not change the parameters of the constructor
  public OperatorManagementSystem() {}

  public ArrayList<Operator> operators = new ArrayList<Operator>();

  public void searchOperators(String keyword) {
    int numberOfOperators = this.operators.size();
    if (numberOfOperators == 0) {
      MessageCli.OPERATORS_FOUND.printMessage("are", "no", "s", ".");
      return;
    } else if (numberOfOperators == 1) {
      MessageCli.OPERATORS_FOUND.printMessage("is", "1", "", ":");
    } else {
      MessageCli.OPERATORS_FOUND.printMessage("are", Integer.toString(numberOfOperators), "s", ":");
    }
    for (Operator thisOperator : this.operators) {
      MessageCli.OPERATOR_ENTRY.printMessage(thisOperator.getName(), thisOperator.getOperatorID(), thisOperator.getLocation().getFullName());
    }
  }

  public void createOperator(String operatorName, String location) {

    // Assign the a location based on the user's input location string
    Types.Location locationToAssign = Location.fromString(location);
    if (locationToAssign == null) {
      MessageCli.OPERATOR_NOT_CREATED_INVALID_LOCATION.printMessage(location);
      return;
    }

    // Ensure that the operator name has more than 3 characters
    if (operatorName.strip().length() < 3) {
      MessageCli.OPERATOR_NOT_CREATED_INVALID_OPERATOR_NAME.printMessage(operatorName);
      return;
    }

    // Append the operator's initials to the operator ID
    String operatorID = "";
    String[] words = operatorName.split(" ");
    for (String word : words) {
      operatorID += Character.toString(word.charAt(0)).toUpperCase();
    }

    // Append the location abbreviation to the operator ID
    operatorID += "-";
    operatorID += locationToAssign.getLocationAbbreviation().toUpperCase();

    // Check for duplicate operators in the same location
    int operatorCount = 1;
    for (Operator existingOperator : this.operators) {
      if (existingOperator.getLocation() == locationToAssign) {
        if (existingOperator.getName().equals(operatorName)) {
          MessageCli.OPERATOR_NOT_CREATED_ALREADY_EXISTS_SAME_LOCATION.printMessage(operatorName, locationToAssign.getFullName());
          return;
        }
        // Count each operator in the same location
        operatorCount++;
      }
    }

    // Append the three digit number to the operator ID
    String threeDigitNumber = Integer.toString(operatorCount);
    while (threeDigitNumber.length() < 3) {
      // Pad the string with zeros count until it has 3 digits
      threeDigitNumber = "0" + threeDigitNumber;
    }
    operatorID += "-";
    operatorID += threeDigitNumber;

    // Add the new operator to the array
    Operator newOperator = new Operator(operatorName, locationToAssign, operatorID);
    operators.add(newOperator);
    MessageCli.OPERATOR_CREATED.printMessage(operatorName, operatorID, locationToAssign.getFullName());
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
