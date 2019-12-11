package service.impl;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import pojo.order.Order;
import service.OrderService;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    @Override
    public void saveOrder(Order order) {
        orderDao.saveOrder(order);
    }

    @Override
    public Order getOrderById(String oid) {
        return orderDao.getOrderById(oid);
    }

    @Override
    public void updateStatus(String oid, String status) {
        orderDao.updateOrder(oid,status);
    }
}
