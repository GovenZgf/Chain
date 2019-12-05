package pojo;

import pojo.chain_info.SeatType;

import java.sql.Date;

public class Chain {
    private String chainId;
    private String startStation;
    private String endStation;
    private Date departureTime;
    private Date time;
    private Double price;

    public Chain( String chainId, String startStation, String endStation, Date departureTime,Date time, Double price) {
        this.chainId = chainId;
        this.startStation = startStation;
        this.endStation = endStation;
        this.departureTime = departureTime;
        this.price = price;
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
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

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
