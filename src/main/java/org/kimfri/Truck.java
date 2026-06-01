package org.kimfri;

public record Truck(String brand, String model, int year) implements Vehicle {
//  public Truck {
//    if (brand == null || brand.isBlank()) throw new IllegalArgumentException("Brand must not be blank");
//    if (model == null || model.isBlank()) throw new IllegalArgumentException("Model must not be blank");
//    if (year < 1886 || year > 2100)       throw new IllegalArgumentException("Invalid year: " + year);
//  }
}