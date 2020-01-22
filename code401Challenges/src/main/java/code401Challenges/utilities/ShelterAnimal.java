package code401Challenges.utilities;

import java.sql.Date;

public class ShelterAnimal {
  private String name;
  private int age;
  private Date arrivalDate;

  public ShelterAnimal(String name, int age, Date arrivalDate) {
    this.name = name;
    this.age = age;
    this.arrivalDate = arrivalDate;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Date getArrivalDate() {
    return arrivalDate;
  }

  public void setArrivalDate(Date arrivalDate) {
    this.arrivalDate = arrivalDate;
  }
}
