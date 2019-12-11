package service.impl;

import dao.TicketDao;
import dao.impl.TicketDaoImpl;
import pojo.Ticket;
import service.TicketService;

import java.util.List;

public class TicketServiceImpl implements TicketService {
    TicketDao ticketDao = new TicketDaoImpl();
    @Override
    public void generateTicket(Ticket ticket) {
        ticketDao.generateTicket(ticket);
    }

    @Override
    public Ticket getTicketByTicketId(String ticketId) {
        return ticketDao.getTicketByTicketId(ticketId);
    }

    @Override
    public List<Ticket> getAllTicketForUser(String userId) {
        return ticketDao.getAllTicketForUser(userId);
    }

    @Override
    public Ticket getTicketByOrderId(String oid) {
        return ticketDao.getTicketByOrderId(oid);
    }
}
