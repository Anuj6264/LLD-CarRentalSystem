package controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import enums.ReservationStatus;
import utility_classes.RentalStore;
import utility_classes.Reservation;
import utility_classes.User;
import vehicle_factory.Vehicle;

public class ReservationManager {
    private Map<Integer, Reservation> reservations;
    private int reservationId;

    public ReservationManager() {
        this.reservations = new HashMap<>();
        this.reservationId = 1;
    }

    public Reservation createReservation(User user, Vehicle vehicle, RentalStore pickupStore, RentalStore returnStore, Date beginTime, Date endTime) {
        Reservation newReservation = new Reservation(reservationId++, user, vehicle, pickupStore, returnStore, beginTime, endTime);
        reservations.put(newReservation.getId(), newReservation);
        user.addReservation(newReservation);
        return newReservation;
    }

    public void confirmReservation(int reservationId) {
        Reservation reservation = reservations.get(reservationId);
        if(reservation != null)
            reservation.confirmReservation();
    }

    public void startRental(int reservationId) {
        Reservation reservation = reservations.get(reservationId);
        if(reservation != null)
            reservation.startRental();
    }

    public void endRental(int reservationId) {
        Reservation reservation = reservations.get(reservationId);
        if(reservation != null)
            reservation.endRental();
    }

    public void cancelReservation(int reservationId) {
        Reservation reservation = reservations.get(reservationId);
        if(reservation != null)
            reservation.cancelReservation();
    }

}
