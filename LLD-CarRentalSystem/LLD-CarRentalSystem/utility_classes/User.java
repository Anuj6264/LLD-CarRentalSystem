package utility_classes;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private int id;
    private String email;
    private List<Reservation> reservations;

    public User(String name, int id, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.reservations = new ArrayList<>(); 
    }

    public int getId() {
        return this.id;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }

}
