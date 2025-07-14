package vehicle_factory;

import enums.VehicleStatus;
import enums.VehicleType;

public abstract class Vehicle {
    private String registrationNumber;
    private String model;
    private VehicleType type;
    private VehicleStatus status;
    private double baseRentalPrice; // Can use pricingStrategy here as well as additional property

    public Vehicle(String registrationNumber, String model, VehicleType type, double baseRentalPrice) {
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.status = VehicleStatus.AVAILABLE;
        this.type = type;
        this.baseRentalPrice = baseRentalPrice;
    }

    public abstract double calculateFare(int days);

    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    public String getModel() {
        return this.model;
    }

    public VehicleStatus getStatus() {
        return this.status;
    }

    public VehicleType getType() {
        return this.type;
    }

    public void setStatus(VehicleStatus vehicleStatus) {
        this.status = vehicleStatus;
    }

    public double getBaseRentalPrice() {
        return this.baseRentalPrice;
    }

}
