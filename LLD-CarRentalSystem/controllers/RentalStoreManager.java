package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enums.ReservationStatus;
import payment_strategy.PaymentStrategy;
import utility_classes.RentalStore;
import utility_classes.Reservation;
import utility_classes.User;
import vehicle_factory.Vehicle;

public class RentalStoreManager {
    private List<RentalStore> stores;
    private PaymentStrategy paymentStrategy;
    private Map<Integer, User> users;
    private ReservationManager reservationManager;
    private static RentalStoreManager instance;

    private RentalStoreManager() {
        this.stores = new ArrayList<>();
        this.paymentStrategy = null;
        this.users = new HashMap<>();
        this.reservationManager = new ReservationManager();
    }

    public static synchronized RentalStoreManager getInstance() {
        if(instance == null) {
            instance = new RentalStoreManager();
        }
        return instance;
    }

    public RentalStore getStore(int storeId) {
        for(RentalStore store: stores) {
            if(store.getId() == storeId)
                return store;
        }
        return null;
    }

    public List<RentalStore> getStores() {
        return this.stores;
    }

    public User getUser(int userId) {
        return users.get(userId);
    }

    public void addStore(RentalStore store) {
        stores.add(store);
    }

    public void registerUser(User user) {
        int userId = user.getId();
        if(users.get(userId) != null) {
            System.out.println("User with id : " + userId + "Already exists in the system");
            return;
        }
        users.put(userId, user);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public Reservation createReservation(User user, Vehicle vehicle, RentalStore pickupStore, RentalStore returnStore, Date beginTime, Date endTime) {
        for(Vehicle vehiclee: pickupStore.getAvailableVehicles()) {
            if(vehicle == vehiclee)
                return reservationManager.createReservation(user, vehicle, pickupStore, returnStore, beginTime, endTime);
        }
        return null;
    }

    public void confirmReservation(int reservationId) {
        reservationManager.confirmReservation(reservationId);
    }

    public void startRental(int reservationId) {
        reservationManager.startRental(reservationId);
    }

    public void endRental(int reservationId) {
        reservationManager.endRental(reservationId);
    }

    public void cancelReservation(int reservationId) {
        reservationManager.cancelReservation(reservationId);
    }

    public void processPayment(PaymentStrategy paymentStrategy, double amount) {
        paymentStrategy.processPayment(amount);
    }

}
