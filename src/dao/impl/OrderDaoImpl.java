package dao.impl;

import com.mysql.cj.xdevapi.SqlDataResult;
import dao.OrderDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import pojo.order.Order;
import utils.C3P0Utils;

import java.sql.SQLException;

public class OrderDaoImpl implements OrderDao {
    private QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

    @Override
    public void saveOrder(Order order) {
        String sql = "insert into user_order(orderId,userId,passengerName,passengerIDcard,orderDateTime,orderStatus,mealsName,mealsPrice,ticketPrice,accountPayable)" +
                "values(?,?,?,?,?,?,?,?,?,?)";
        Object[] params = new Object[]
                {order.getOrderId(), order.getUserId(),
                        order.getPassengerName(), order.getPassengerIDcard(),
                        order.getOrderDatetime(), order.getOrderStatus(),order.getMealsName(),
                        order.getMealsPrice(),order.getTicketPrice(),order.getTicketPrice()+order.getMealsPrice()
        };

        try{
            queryRunner.update(sql,params);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Order getOrderById(String orderId) {
        Order order = null;
        String sql = "select * from user_order where orderId = ?";
        try{
            order = (Order) queryRunner.query(sql, new BeanHandler<>(Order.class),orderId);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public void updateOrder(String oid,String status) {
        String sql ="update user_order set orderStatus=? where orderId = ?";
        Object[] params = new Object[]{status,oid};
        try{
            queryRunner.update(sql,params);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
