package dao;

import pojo.Ticket;

import java.util.List;

public interface TicketDao {
    void generateTicket(Ticket ticket);
    Ticket getTicketByTicketId(String tid);
    List<Ticket> getAllTicketForUser(String userId);
    Ticket getTicketByOrderId(String oid);

}
