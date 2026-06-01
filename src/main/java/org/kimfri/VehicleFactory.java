package org.kimfri;

@FunctionalInterface
public interface VehicleFactory<B, M, Y extends Number> {
  Vehicle create(String brand, String model, int year);
}
