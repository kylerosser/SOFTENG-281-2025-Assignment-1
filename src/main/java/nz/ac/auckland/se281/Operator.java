package nz.ac.auckland.se281;

public class Operator {

  public String name;
  public Types.Location location;
  public String operatorID;
  
  public Operator(String name, Types.Location location, String operatorID) {
    this.name = name;
    this.location = location;
    this.operatorID = operatorID;
  }
}
