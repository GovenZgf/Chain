package pojo;

public class Passenger {
    private String passengerName;
    private String passengerIDcard;
    private String passengerType;
    public Passenger() {
    }

    public String getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    public Passenger(String passengerName, String passengerIDcard, String passengerType) {
        this.passengerName = passengerName;
        this.passengerIDcard = passengerIDcard;
        this.passengerType = passengerType;
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
