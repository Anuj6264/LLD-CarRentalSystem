package vehicle_factory;

import enums.VehicleType;

public class VehicleFactory {
    public Vehicle createVehicle(String registrationNumber, String model, VehicleType type, double baseRentalPrice) {
        switch (type) {
            case ECONOMY:
                return new EconomyVehicle(registrationNumber, model, type, baseRentalPrice);
            case LUXURY:
                return new LuxuryVehicle(registrationNumber, model, type, baseRentalPrice);
            case SUV:
                return new SUVVehicle(registrationNumber, model, type, baseRentalPrice);
            default:
                return null;
        }
    }
}
