package dao.impl;

import dao.OrderDao;
import org.apache.commons.dbutils.QueryRunner;
import pojo.order.Order;
import utils.C3P0Utils;

public class OrderDaoImpl implements OrderDao {
    private QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

    @Override
    public void saveOrder(Order order) {
        String sql = "insert into Order(orderId,userId,passengerName,passengerIDcard,orderDate,orderPrice,orderStatus)" +
                "values(?,?,?,?,?,?,?)";
        Object[] params = new Object[]
                {order.getOrderId(), order.getUser().getUserId(), order.getPassenger().getPassengerName(), order.getPassenger().getPassengerIDcard(), order.getOrderDate(), order.getAccountPayable(), order.getOrderStatus()
        };

        try{
            queryRunner.update(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
