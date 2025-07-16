import java.util.Date;

import controllers.RentalStoreManager;
import enums.VehicleType;
import payment_strategy.CardPayment;
import payment_strategy.UPIPayment;
import utility_classes.Location;
import utility_classes.RentalStore;
import utility_classes.Reservation;
import utility_classes.User;
import vehicle_factory.Vehicle;
import vehicle_factory.VehicleFactory;

public class Main {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();
        Vehicle luxuryVehicle = vehicleFactory.createVehicle("RJ09", "Porche", VehicleType.LUXURY, 100.0);
        Vehicle suvVehicle = vehicleFactory.createVehicle("RJ16", "Thar", VehicleType.SUV, 110.0);
        Vehicle economyVehicle = vehicleFactory.createVehicle("MP17", "Nano", VehicleType.ECONOMY, 70.0);

        RentalStore rentalStore1 = new RentalStore(1, new Location("Pune", "Maharashtra", "411003", "Khadki"), "Rental Store 1");
        RentalStore rentalStore2 = new RentalStore(2, new Location("Gwalior", "Madhya Pradesh", "474406", "Morar"), "Rental Store 2");

        rentalStore1.addVehicle(economyVehicle);
        rentalStore1.addVehicle(luxuryVehicle);
        rentalStore2.addVehicle(suvVehicle);

        RentalStoreManager rentalStoreManager = RentalStoreManager.getInstance();
        rentalStoreManager.addStore(rentalStore1);
        rentalStoreManager.addStore(rentalStore2);

        User user1 = new User("Anuj", 1, "anujeenitb@gmail.com");
        User user2 = new User("XYZ", 2, "xyz@gmail.com");

        rentalStoreManager.registerUser(user1);
        rentalStoreManager.registerUser(user2);

        Reservation reservation1 = rentalStoreManager.createReservation(user1, economyVehicle, rentalStore1, rentalStore2, new Date(2025 - 1900, 4, 1), new Date(2025 - 1900, 5, 15));
        Reservation reservation2 = rentalStoreManager.createReservation(user2, suvVehicle, rentalStore2, rentalStore1, new Date(2025 - 1900, 4, 1), new Date(2025 - 1900, 5, 15));

        rentalStoreManager.confirmReservation(reservation1.getId());
        rentalStoreManager.confirmReservation(reservation2.getId());

        rentalStoreManager.processPayment(new UPIPayment(), 472.0);
        rentalStoreManager.processPayment(new CardPayment(), 4422.0);

    }
}
