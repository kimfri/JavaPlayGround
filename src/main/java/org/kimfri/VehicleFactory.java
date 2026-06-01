package org.kimfri;

/**
 * Factory for creating {@link Vehicle} instances.
 *
 * @param <T> the type of Vehicle this factory produces
 */
@FunctionalInterface
public interface VehicleFactory<T extends Vehicle> {
  T create(String brand, String model, int year);
}