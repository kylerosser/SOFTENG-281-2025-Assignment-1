package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Types.ActivityType;
import nz.ac.auckland.se281.Types.Location;

public class OperatorManagementSystem {

  // Do not change the parameters of the constructor
  public OperatorManagementSystem() {}

  private ArrayList<Operator> operators = new ArrayList<Operator>();

  public void searchOperators(String keyword) {
    // Create a list to store operators that match
    // the keyword query.
    ArrayList<Operator> queriedOperators = new ArrayList<Operator>();

    String sanitisedKeyword = keyword.strip().toLowerCase();

    // Handle case of asterisk (display all operators):
    if (keyword.strip().equals("*")) {
      queriedOperators = this.operators;
    } else {
      // Search for any operators that match the keyword
      // and add them to the queriedOperators list
      for (Operator thisOperator : this.operators) {
        Location thisLocation = thisOperator.getLocation();

        boolean matchesLocationTeReoName = thisLocation.getNameTeReo()
          .toLowerCase()
          .contains(sanitisedKeyword);
        
        boolean matchesLocationEnglishName = thisLocation.getNameEnglish()
          .toLowerCase()
          .contains(sanitisedKeyword);

        boolean matchesName = thisOperator.getName()
          .toLowerCase()
          .contains(sanitisedKeyword);

        boolean matchesLocationAbbreviation = thisLocation
          .getLocationAbbreviation()
          .toLowerCase()
          .contains(sanitisedKeyword);

        // If it matches any of the names or locations then
        // add this operator to the query list
        if (
          matchesLocationTeReoName ||
          matchesLocationEnglishName ||
          matchesName ||
          matchesLocationAbbreviation
        ) {
          queriedOperators.add(thisOperator);
        }
      }
    }

    int numberOfOperators = queriedOperators.size();
    if (numberOfOperators == 0) {
      MessageCli.OPERATORS_FOUND.printMessage("are", "no", "s", ".");
      return;
    } else if (numberOfOperators == 1) {
      MessageCli.OPERATORS_FOUND.printMessage("is", "1", "", ":");
    } else {
      MessageCli.OPERATORS_FOUND.printMessage("are", Integer.toString(numberOfOperators), "s", ":");
    }
    for (Operator thisOperator : queriedOperators) {
      MessageCli.OPERATOR_ENTRY.printMessage(thisOperator.getName(), thisOperator.getOperatorId(), thisOperator.getLocation().getFullName());
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
    String operatorId = "";
    String[] words = operatorName.split(" ");
    for (String word : words) {
      operatorId += Character.toString(word.charAt(0)).toUpperCase();
    }

    // Append the location abbreviation to the operator ID
    operatorId += "-";
    operatorId += locationToAssign.getLocationAbbreviation().toUpperCase();

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
    operatorId += "-";
    operatorId += threeDigitNumber;

    // Add the new operator to the array
    Operator newOperator = new Operator(operatorName, locationToAssign, operatorId);
    operators.add(newOperator);
    MessageCli.OPERATOR_CREATED.printMessage(operatorName, operatorId, locationToAssign.getFullName());
  }

  public void viewActivities(String operatorId) {
    // Search for operators that match the supplied operatorId
    Operator operator = null;
    for (Operator thisOperator : this.operators) {
      if (thisOperator.getOperatorId().equals(operatorId)) {
        operator = thisOperator;
        break;
      }
    }

    // If no operators match the ID, tell the user and return
    if (operator == null) {
      MessageCli.OPERATOR_NOT_FOUND.printMessage(operatorId);
      return;
    }

    // Get the list of all activities under this operator
    ArrayList<Activity> activityList = operator.getActivityList();

    // Print an appropriate message if no activities found
    if (activityList.size() == 0) {
      MessageCli.ACTIVITIES_FOUND.printMessage("are", "no", "ies", ".");
      return;
    }

    // Display all matching activities (watching out for pluralisation)
    if (activityList.size() == 1) {
      MessageCli.ACTIVITIES_FOUND.printMessage("is", "1", "y", ":");
    } else {
      MessageCli.ACTIVITIES_FOUND.printMessage("are", Integer.toString(activityList.size()), "ies", ":");
    }
    for (Activity thisActivity : activityList) {
      MessageCli.ACTIVITY_ENTRY.printMessage(
        thisActivity.getName(),
        thisActivity.getActivityId(),
        thisActivity.getActivityType().toString(),
        operator.getName()
      );
    }
    
  }

  public void createActivity(String activityName, String activityType, String operatorId) {
    // Reject an invalid activityName
    if (activityName.trim().length() < 3) {
      MessageCli.ACTIVITY_NOT_CREATED_INVALID_ACTIVITY_NAME.printMessage(activityName);
      return;
    }

    // Search for operators that match the operatorId
    Operator operator = null;
    for (Operator thisOperator : this.operators) {
      if (thisOperator.getOperatorId().equals(operatorId)) {
        operator = thisOperator;
        break;
      }
    }

    // If no operators match the ID, tell the user and abort activity creation
    if (operator == null) {
      MessageCli.ACTIVITY_NOT_CREATED_INVALID_OPERATOR_ID.printMessage(operatorId);
      return;
    }

    // Get the number of activities in the operator
    ArrayList<Activity> activityList = operator.getActivityList();
    int activityCount = activityList.size();

    // Create the three digit number as a formatted string
    String threeDigitNumber = Integer.toString(activityCount + 1);
    while (threeDigitNumber.length() < 3) {
      // Pad the string with zeros count until it has 3 digits
      threeDigitNumber = "0" + threeDigitNumber;
    }

    // Create the activity Id
    String activityId = operatorId + "-" + threeDigitNumber;

    // Create the activity type from the string
    ActivityType convertedActivityType = ActivityType.fromString(activityType);

    Activity newActivity = new Activity(activityName, activityId, convertedActivityType, operator);
    activityList.add(newActivity);
    MessageCli.ACTIVITY_CREATED.printMessage(
      activityName, 
      activityId, 
      convertedActivityType.toString(), 
      operator.getName()
    );
  }

  public void searchActivities(String keyword) {
    String sanitisedKeyword = keyword.strip().toLowerCase();

    // Iterate over all activities and save matching activities to a query list
    ArrayList<Activity> activityQueryList = new ArrayList<Activity>();
    for (Operator thisOperator : operators) {
      for (Activity thisActivity : thisOperator.getActivityList()) {
        // If the keyword is an asterisk, we must add all
        // activities to the query list
        if (sanitisedKeyword.equals("*")) {
          activityQueryList.add(thisActivity);
          continue;
        }

        // If the keyword is not an asterisk, check if it
        // matches activity name or type, or operator location
        // and add matching activities to the query list.
        boolean matchesActivityName = thisActivity
          .getName()
          .toLowerCase()
          .contains(sanitisedKeyword);

        boolean matchesActivityType = thisActivity
          .getActivityType()
          .toString()
          .toLowerCase()
          .contains(sanitisedKeyword);

        boolean matchesOperatorLocationEnglish = thisOperator
          .getLocation()
          .getNameEnglish()
          .toLowerCase()
          .contains(sanitisedKeyword);

        boolean matchesOperatorLocationTeReo = thisOperator
          .getLocation()
          .getNameTeReo()
          .toLowerCase()
          .contains(sanitisedKeyword);

        boolean matchesOperatorLocationAbbreviation = thisOperator
          .getLocation()
          .getLocationAbbreviation()
          .toLowerCase()
          .contains(sanitisedKeyword);
        
        if (
          matchesActivityName ||
          matchesActivityType ||
          matchesOperatorLocationEnglish ||
          matchesOperatorLocationTeReo ||
          matchesOperatorLocationAbbreviation
        ) {
          activityQueryList.add(thisActivity);
        }

      }
    }

    // Handle plural/singular output messages
    if (activityQueryList.size() == 0) {
      MessageCli.ACTIVITIES_FOUND.printMessage("are", "no", "ies", ".");
      return;
    } else if (activityQueryList.size() == 1){
      MessageCli.ACTIVITIES_FOUND.printMessage("is", "1", "y", ":");
    } else {
      MessageCli.ACTIVITIES_FOUND.printMessage("are", Integer.toString(activityQueryList.size()), "ies", ":");
    }
    
    // Display all matching actvities from the query list
    for (Activity thisActivity : activityQueryList) {
      MessageCli.ACTIVITY_ENTRY.printMessage(
        thisActivity.getName(), 
        thisActivity.getActivityId(),
        thisActivity.getActivityType().toString(),
        thisActivity.getOperator().getName()
      );
    }
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
