package service;

import pojo.order.Order;

public interface OrderService {
    void saveOrder(Order order);
    Order getOrderById(String oid);
    void updateStatus(String oid,String status);

}
