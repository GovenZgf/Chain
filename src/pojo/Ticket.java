package pojo;

import pojo.chain_info.SeatOrder;
import pojo.chain_info.SeatType;

public class Ticket {
    private String ticketId;
    private String chainId;
    private String orderId;
    private Double ticketPrice;

    public Ticket(String ticketId, String chainId, String orderId, Double ticketPrice) {
        this.ticketId = ticketId;
        this.chainId = chainId;
        this.orderId = orderId;
        this.ticketPrice = ticketPrice;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getChainId() {
        return chainId;
    }

    public void setChainId(String chainId) {
        this.chainId = chainId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Ticket() {
    }

}
