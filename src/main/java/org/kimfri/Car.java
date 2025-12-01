package org.kimfri;

final class Car extends Vehicle {
  @Override
  void whoAmI() {
    System.err.println("Inside WhoAmI");
  }
}
