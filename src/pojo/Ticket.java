package pojo;

import pojo.chain_info.SeatOrder;
import pojo.chain_info.SeatType;

public class Ticket {
    private String ticketId;
    private Chain chain;
    private Passenger ticketPassenger;
    private Double ticketPrice;
    private SeatType seatType;
    private SeatOrder seatOrder;

    public Ticket() {
    }

    public Ticket(String ticketId, Chain chain, Passenger ticketPassenger, Double ticketPrice, SeatType seatType, SeatOrder seatOrder) {
        this.ticketId = ticketId;
        this.chain = chain;
        this.ticketPassenger = ticketPassenger;
        this.ticketPrice = ticketPrice;
        this.seatType = seatType;
        this.seatOrder = seatOrder;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Chain getChain() {
        return chain;
    }

    public void setChain(Chain chain) {
        this.chain = chain;
    }

    public Passenger getTicketPassenger() {
        return ticketPassenger;
    }

    public void setTicketPassenger(Passenger ticketPassenger) {
        this.ticketPassenger = ticketPassenger;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public SeatOrder getSeatOrder() {
        return seatOrder;
    }

    public void setSeatOrder(SeatOrder seatOrder) {
        this.seatOrder = seatOrder;
    }
}
