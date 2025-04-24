package nz.ac.auckland;

import nz.ac.auckland.se281.Types;

public class Activity {
  private String name;
  private Types.ActivityType activityType;

  public Activity(String name, Types.ActivityType activityType) {
    this.name = name;
    this.activityType = activityType;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Types.ActivityType getActivityType() {
    return activityType;
  }

  public void setActivityType(Types.ActivityType activityType) {
    this.activityType = activityType;
  }
}
