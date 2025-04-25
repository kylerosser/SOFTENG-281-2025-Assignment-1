package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Operator {

  private String name;
  private Types.Location location;
  private String operatorId;
  private ArrayList<Activity> activityList;

  public Operator(String name, Types.Location location, String operatorId) {
    this.name = name;
    this.location = location;
    this.operatorId = operatorId;
    this.activityList = new ArrayList<Activity>();
  }

  public String getName() {
    return name;
  }

  public ArrayList<Activity> getActivityList() {
    return activityList;
  }

  public void setActivityList(ArrayList<Activity> activityList) {
    this.activityList = activityList;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Types.Location getLocation() {
    return location;
  }

  public String getOperatorId() {
    return operatorId;
  }

  public void setOperatorId(String operatorId) {
    this.operatorId = operatorId;
  }

  public void setLocation(Types.Location location) {
    this.location = location;
  }
}
