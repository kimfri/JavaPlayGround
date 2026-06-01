package org.kimfri;

public class Truck implements Vehicle {
  private final String brand;
  private final String model;
  private final int year;

  public Truck(String brand, String model, int year) {
    this.brand = brand;
    this.model = model;
    this.year = year;
  }

  @Override
  public String toString() {
    return "Truck{" +
        "brand='" + brand + '\'' +
        ", model='" + model + '\'' +
        ", year=" + year +
        '}';
  }
}
