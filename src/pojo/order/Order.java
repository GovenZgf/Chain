package pojo.order;


import java.util.Date;

public class Order {
    private String orderId;
    private String userId;
    private String passengerIDcard;
    private String passengerName;
    private Date orderDatetime;
    private String orderStatus;
    private String mealsName;
    private double mealsPrice;
    private Double accountPayable;//应付款项

    public Order(String orderId, String userId, String passengerIDcard, String passengerName, Date orderDatetime, String orderStatus, String mealsName, double mealsPrice, Double accountPayable) {
        this.orderId = orderId;
        this.userId = userId;
        this.passengerIDcard = passengerIDcard;
        this.passengerName = passengerName;
        this.orderDatetime = orderDatetime;
        this.orderStatus = orderStatus;
        this.mealsName = mealsName;
        this.mealsPrice = mealsPrice;
        this.accountPayable = accountPayable;
    }

    public Order() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassengerIDcard() {
        return passengerIDcard;
    }

    public void setPassengerIDcard(String passengerIDcard) {
        this.passengerIDcard = passengerIDcard;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Date getOrderDatetime() {
        return orderDatetime;
    }

    public void setOrderDatetime(Date orderDatetime) {
        this.orderDatetime = orderDatetime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getMealsName() {
        return mealsName;
    }

    public void setMealsName(String mealsName) {
        this.mealsName = mealsName;
    }

    public double getMealsPrice() {
        return mealsPrice;
    }

    public void setMealsPrice(double mealsPrice) {
        this.mealsPrice = mealsPrice;
    }

    public Double getAccountPayable() {
        return accountPayable;
    }

    public void setAccountPayable(Double accountPayable) {
        this.accountPayable = accountPayable;
    }
}