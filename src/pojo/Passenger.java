package pojo;

public class Passenger {
    private String passengerName;
    private String passengerIDcard;

    public Passenger() {
    }

    public Passenger(String passengerName, String passengerIDcard) {
        this.passengerName = passengerName;
        this.passengerIDcard = passengerIDcard;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerIDcard() {
        return passengerIDcard;
    }

    public void setPassengerIDcard(String passengerIDcard) {
        this.passengerIDcard = passengerIDcard;
    }
}
