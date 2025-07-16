package vehicle_factory;

import enums.VehicleType;

public class SUVVehicle extends Vehicle {
    private static final double RATE_MULTIPLIER = 1.5;
    public SUVVehicle(String registrationNumber, String model, VehicleType type, double baseRentalPrice) {
        super(registrationNumber, model, type, baseRentalPrice);
    }
    
    @Override
    public double calculateFare(int days) {
        return getBaseRentalPrice() * days * RATE_MULTIPLIER;
    }
}
