package nz.ac.auckland.se281;

public class Operator {

  private String name;
  private Types.Location location;
  private String operatorId;
  
  public Operator(String name, Types.Location location, String operatorID) {
    this.name = name;
    this.location = location;
    this.operatorId = operatorID;
  }

  public String getName() {
    return name;
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
