package vehicle_factory;

import enums.VehicleType;

public class EconomyVehicle extends Vehicle {
    private static final double RATE_MULTIPLIER = 1.0;
    public EconomyVehicle(String registrationNumber, String model, VehicleType type, double baseRentalPrice) {
        super(registrationNumber, model, type, baseRentalPrice);
    }
    
    @Override
    public double calculateFare(int days) {
        return getBaseRentalPrice() * days * RATE_MULTIPLIER;
    }
}
