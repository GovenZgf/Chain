package pojo.order;


import pojo.Passenger;
import pojo.User;

import java.util.Date;

public class Order {
    private String orderId;
    private User user;
    private Passenger passenger;
    private Date orderDate;
    private OrderStatus orderStatus;
    private MealsOrder mealsOrder;
    private Double accountPayable;//应付款项

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order(String orderId, User user, Passenger passenger, Date orderDate, OrderStatus orderStatus, MealsOrder mealsOrder, Double accountPayable) {
        this.orderId = orderId;
        this.user = user;
        this.passenger = passenger;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.mealsOrder = mealsOrder;
        this.accountPayable = accountPayable;
    }

    public Order() {
    }

    public MealsOrder getMealsOrder() {
        return mealsOrder;
    }

    public void setMealsOrder(MealsOrder mealsOrder) {
        this.mealsOrder = mealsOrder;
    }

    public Double getAccountPayable() {
        return accountPayable;
    }

    public void setAccountPayable(Double accountPayable) {
        this.accountPayable = accountPayable;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
