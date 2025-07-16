package utility_classes;

import java.util.Date;

import enums.ReservationStatus;
import enums.VehicleStatus;
import vehicle_factory.Vehicle;

public class Reservation {
    private int id;
    private User user;
    private Vehicle vehicle;
    private RentalStore pickupStore;
    private RentalStore returnStore;
    private ReservationStatus reservationStatus;
    private Date beginTime;
    private Date endTime;
    private double totalFare;

    public Reservation(int id, User user, Vehicle vehicle, RentalStore pickupStore, RentalStore returnStore, Date beginTime, Date endTime) {
        this.id = id;
        this.vehicle = vehicle;
        this.pickupStore = pickupStore;
        this.returnStore = returnStore;
        this.reservationStatus = ReservationStatus.PENDING;
        this.beginTime = beginTime;
        this.endTime = endTime;

        long diffInMillies = endTime.getTime() - beginTime.getTime();
        int days = (int) (diffInMillies / (1000 * 60 * 60 * 24)) + 1;
        this.totalFare = vehicle.calculateFare(days);
    }

    public void confirmReservation() {
        if(this.reservationStatus == ReservationStatus.PENDING) {
            reservationStatus = ReservationStatus.CONFIRMED;
            this.vehicle.setStatus(VehicleStatus.RESERVED);
        }
    }

    public void startRental() {
        if(this.reservationStatus == ReservationStatus.CONFIRMED) {
            reservationStatus = ReservationStatus.IN_PROGRESS;
            this.vehicle.setStatus(VehicleStatus.RENTED);
        }
    }

    public void endRental() {
        if(this.reservationStatus == ReservationStatus.IN_PROGRESS) {
            reservationStatus = ReservationStatus.COMPLETED;
            this.vehicle.setStatus(VehicleStatus.AVAILABLE);
        }
    }

    public void cancelReservation() {
        if(this.reservationStatus == ReservationStatus.PENDING || this.reservationStatus == ReservationStatus.CONFIRMED) {
            reservationStatus = ReservationStatus.CANCELED;
            this.vehicle.setStatus(VehicleStatus.AVAILABLE);
        }
    }

    public int getId() {
        return this.id;
    }

    public double getFare() {
        return this.totalFare;
    }
    
}
