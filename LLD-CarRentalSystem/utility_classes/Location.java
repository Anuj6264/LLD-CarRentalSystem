package utility_classes;

public class Location {
    private String city;
    private String state;
    private String pincode;
    private String address;

    public Location(String city, String state, String pincode, String address) {
        this.address = address;
        this.city = city;
        this.pincode = pincode;
        this.state = state;
    }

} 