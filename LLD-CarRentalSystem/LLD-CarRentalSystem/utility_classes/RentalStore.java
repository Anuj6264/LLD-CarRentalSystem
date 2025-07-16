package utility_classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enums.VehicleStatus;
import vehicle_factory.Vehicle;

public class RentalStore {
    private int id;
    private Location location;
    private String name;
    private Map<String, Vehicle> vehicles;

    public RentalStore(int id, Location location, String name) {
        this.id = id;
        this.location = location;
        this.name = name;
        this.vehicles = new HashMap<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getRegistrationNumber(), vehicle);
    }

    public void removeVehicle(String registrationNumber) {
        if(vehicles.get(registrationNumber) != null) {
            vehicles.remove(registrationNumber);
        }
    }

    public Map<String, Vehicle> getAllVehicles() {
        return this.vehicles;
    }

    public int getId() {
        return this.id;
    }

    public Vehicle getVehicle(String registrationNumber) {
        return vehicles.get(registrationNumber);
    }

    public List<Vehicle> getAvailableVehicles() {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for(Vehicle vehicle: vehicles.values()) {
            if(vehicle.getStatus() == VehicleStatus.AVAILABLE)
                availableVehicles.add(vehicle);
        }
        return availableVehicles;
    }

}
