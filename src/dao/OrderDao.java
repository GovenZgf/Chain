package dao;

import pojo.order.Order;

public interface OrderDao {
    void saveOrder(Order order);
    Order getOrderById(String oid);
    void updateOrder(String oid,String status);
}
