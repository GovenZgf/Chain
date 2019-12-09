package dao.impl;

import dao.OrderDao;
import org.apache.commons.dbutils.QueryRunner;
import pojo.order.Order;
import utils.C3P0Utils;

public class OrderDaoImpl implements OrderDao {
    private QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

    @Override
    public void saveOrder(Order order) {
        String sql = "insert into user_order(orderId,userId,passengerName,passengerIDcard,orderDateTime,orderStatus,mealsName,mealsPrice,accountPayable)" +
                "values(?,?,?,?,?,?,?,?,?)";
        Object[] params = new Object[]
                {order.getOrderId(), order.getUserId(),
                        order.getPassengerName(), order.getPassengerIDcard(),
                        order.getOrderDatetime(), order.getOrderStatus(),order.getMealsName(),
                        order.getMealsPrice(),order.getAccountPayable()
        };

        try{
            queryRunner.update(sql,params);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
