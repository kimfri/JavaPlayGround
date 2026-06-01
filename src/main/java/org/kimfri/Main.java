package org.kimfri;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
  private static final Logger LOGGER = LogManager.getLogger(Main.class);

  private final VehicleFactory<String, String, Integer> carFactory = Car::new;
  private final VehicleFactory<String, String, Integer> truckFactory = Truck::new;

  static void main() {
    Main main = new Main();
    main.doit();
  }

  private void doit() {

    Vehicle car = carFactory.create("BMW", "M", 2018);
    LOGGER.error(() -> "Car Factory: " + car);
    printVehicleType(car);
    final Vehicle truck = truckFactory.create("Mack", "F45", 2026);
    LOGGER.error(() -> "Truck Factory: " + truck);
    printVehicleType(truck);
  }

  void printVehicleType(Vehicle vehicle) {
    if (vehicle instanceof Car) {
      LOGGER.error(() -> "It's a Car");
    } else if (vehicle instanceof Truck) {
      LOGGER.error(() -> "It's a Truck");
    } else {
      LOGGER.error(() -> "Unknown Vehicle");
    }
  }
}
