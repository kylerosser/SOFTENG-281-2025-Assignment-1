package nz.ac.auckland.se281;

public class Operator {

  private String name;
  private Types.Location location;
  private String operatorID;
  
  public Operator(String name, Types.Location location, String operatorID) {
    this.name = name;
    this.location = location;
    this.operatorID = operatorID;
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

  public void setLocation(Types.Location location) {
    this.location = location;
  }

  public String getOperatorID() {
    return operatorID;
  }

  public void setOperatorID(String operatorID) {
    this.operatorID = operatorID;
  }
}
