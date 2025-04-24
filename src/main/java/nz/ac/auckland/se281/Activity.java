package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.ActivityType;

public class Activity {
  private String name;
  private String activityId;
  private ActivityType activityType;

  public Activity(String name, String activityId, ActivityType activityType) {
    this.name = name;
    this.activityType = activityType;
    this.activityId = activityId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ActivityType getActivityType() {
    return activityType;
  }

  public void setActivityType(ActivityType activityType) {
    this.activityType = activityType;
  }

  public String getActivityId() {
    return activityId;
  }

  public void setActivityId(String activityId) {
    this.activityId = activityId;
  }
}
