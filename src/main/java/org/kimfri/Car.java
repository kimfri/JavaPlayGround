package org.kimfri;

public class Car implements Vehicle {
  private final String brand;
  private final String model;
  private final int year;

  public Car(String brand, String model, int year) {
    this.brand = brand;
    this.model = model;
    this.year = year;
  }

  @Override
  public String toString() {
    return "Car{" +
        "brand='" + brand + '\'' +
        ", model='" + model + '\'' +
        ", year=" + year +
        '}';
  }
}
