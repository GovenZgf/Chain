package pojo;

import pojo.chain_info.SeatType;

public class ChainCarriage {
    private String carriageId;
    private String carriageTypes;
    private int seatNum;
    private String chainId;
    private double price;
    public ChainCarriage(){}

    public ChainCarriage(String carriageId, String carriageTypes, int seatNum, String chainId, double price) {
        this.carriageId = carriageId;
        this.carriageTypes = carriageTypes;
        this.seatNum = seatNum;
        this.chainId = chainId;
        this.price = price;
    }

    public String getCarriageTypes() {
        return carriageTypes;
    }

    public void setCarriageTypes(String carriageTypes) {
        this.carriageTypes = carriageTypes;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCarriageId() {
        return carriageId;
    }

    public void setCarriageId(String carriageId) {
        this.carriageId = carriageId;
    }

    public String getChainId() {
        return chainId;
    }

    public void setChainId(String chainId) {
        this.chainId = chainId;
    }
}
