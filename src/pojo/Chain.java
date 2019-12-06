package pojo;

import java.sql.Time;
import java.sql.Timestamp;

public class Chain {
    private String chainId;
    private String startStation;
    private String endStation;
    private Timestamp departureTime;
    private Time time;
    private Double price;

    public Chain(String chainId, String startStation, String endStation, Timestamp departureTime, Time time, Double price) {
        this.chainId = chainId;
        this.startStation = startStation;
        this.endStation = endStation;
        this.departureTime = departureTime;
        this.price = price;
        this.time = time;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getChainId() {
        return chainId;
    }

    public void setChainId(String chainId) {
        this.chainId = chainId;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
