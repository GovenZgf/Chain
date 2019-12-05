package pojo;

import pojo.chain_info.SeatType;

public class ChainCarriage {
    private String carriageId;
    private int numberOfSeat;
    private SeatType seatType;
    private Chain belongToChain;

    public ChainCarriage(String carriageId, int numberOfSeat, SeatType seatType, Chain belongToChain) {
        this.carriageId = carriageId;
        this.numberOfSeat = numberOfSeat;
        this.seatType = seatType;
        this.belongToChain = belongToChain;
    }

    public String getCarriageId() {
        return carriageId;
    }

    public void setCarriageId(String carriageId) {
        this.carriageId = carriageId;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public Chain getBelongToChain() {
        return belongToChain;
    }

    public void setBelongToChain(Chain belongToChain) {
        this.belongToChain = belongToChain;
    }
}
