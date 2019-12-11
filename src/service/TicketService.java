package service;

import pojo.Ticket;

import java.util.List;

public interface TicketService {
    void generateTicket(Ticket ticket);
    Ticket getTicketByTicketId(String ticketId);
    List<Ticket> getAllTicketForUser(String userId);
    Ticket getTicketByOrderId(String oid);
}
