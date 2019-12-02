package pojo.chain_info;

public class SeatOrder {
    private short carriageNum;
    private short seatNum;

    public SeatOrder(short carriageNum, short seatNum) {
        this.carriageNum = carriageNum;
        this.seatNum = seatNum;
    }

    public SeatOrder() {
    }

    public short getCarriageNum() {
        return carriageNum;
    }

    public void setCarriageNum(short carriageNum) {
        this.carriageNum = carriageNum;
    }

    public short getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(short seatNum) {
        this.seatNum = seatNum;
    }
}
