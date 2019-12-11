package dao.impl;

import dao.TicketDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.Ticket;
import utils.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

public class TicketDaoImpl implements TicketDao{
    QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());


    @Override
    public void generateTicket(Ticket ticket) {
        String sql = "insert into ticket_info values(?,?,?,?)";
        Object[] params = new Object[]{ticket.getTicketId(),ticket.getOrderId(),ticket.getChainId(),ticket.getTicketPrice()};
        try{
            queryRunner.update(sql,params);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Ticket getTicketByTicketId(String tId) {
        String sql="select * from ticket_info where ticketId = ?";
        Ticket ticket = null;
        try{
            ticket = queryRunner.query(sql,new BeanHandler<>(Ticket.class),tId);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ticket;
    }

    @Override
    public List<Ticket> getAllTicketForUser(String userId) {
        String sql = "select * from ticket_info where orderId IN (select orderId FROM user_order where userId = ?)";

        List<Ticket> tickets = null;
        try{
            tickets = queryRunner.query(sql,new BeanListHandler<>(Ticket.class),userId);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return tickets;
    }

    @Override
    public Ticket getTicketByOrderId(String oid) {
        String sql="select * from ticket_info where orderId = ?";
        Ticket ticket = null;
        try{
            ticket = queryRunner.query(sql,new BeanHandler<>(Ticket.class),oid);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ticket;
    }
}
