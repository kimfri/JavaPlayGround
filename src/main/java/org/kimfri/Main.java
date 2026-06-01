package org.kimfri;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

  private static final Logger LOGGER = LogManager.getLogger(Main.class);

  // Fully typed – no raw types, satisfies S3740
  private final VehicleFactory<Car>   carFactory   = Car::new;
  private final VehicleFactory<Truck> truckFactory = Truck::new;

  public static void main(String[] args) {
    new Main().run();
  }

  private void run() {
    Car   car   = carFactory.create("BMW", "M3", 2018);
    Truck truck = truckFactory.create("Mack", "F45", 2026);

    LOGGER.info("Created: {}", car);
    LOGGER.info("Created: {}", truck);

    printVehicleType(car);
    printVehicleType(truck);
  }

  void printVehicleType(Vehicle vehicle) {
    String description = switch (vehicle) {
      case Car   c -> "Car:   %s %s (%d)".formatted(c.brand(), c.model(), c.year());
      case Truck t -> "Truck: %s %s (%d)".formatted(t.brand(), t.model(), t.year());
      default      -> "Unknown vehicle: " + vehicle;
    };
    LOGGER.info(description);
  }
}