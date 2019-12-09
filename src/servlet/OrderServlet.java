package servlet;

import pojo.Passenger;
import pojo.User;
import pojo.order.MealsOrder;
import pojo.order.Order;
import pojo.order.OrderStatus;
import pojo.utils.OrderUtil;
import service.impl.OrderServiceImpl;
import web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "OrderServlet",urlPatterns = "/OrderServlet")
public class OrderServlet extends BaseServlet {
    private OrderServiceImpl orderService = new OrderServiceImpl();
    public String toBooking(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        request.getRequestDispatcher("booking/booking.jsp").forward(request,response);
        return null;
    }
    public String booking(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{

        User user = (User) request.getSession().getAttribute("user");

        System.out.println(user);
        String orderId = OrderUtil.getOrderIdByTime()+user.getUserId();
        System.out.println(orderId);
        Passenger passenger = new Passenger();
        passenger.setPassengerIDcard(request.getParameter("passengerIDcard"));
        passenger.setPassengerName(request.getParameter("passengerIDcard"));

        MealsOrder mealsOrder = new MealsOrder();
        String mealsName = request.getParameter("mealsOrder");
        mealsOrder.setMealsName(mealsName);
        switch(mealsName){
            case "套餐一":
                mealsOrder.setMealsPrice(80.0);
                break;
            case "套餐二":
                mealsOrder.setMealsPrice(75.0);
                break;
            case "套餐三":
                mealsOrder.setMealsPrice(70.0);
                break;
            case "套餐四":
                mealsOrder.setMealsPrice(65.0);
                break;
            case "套餐五":
                mealsOrder.setMealsPrice(60.0);
                break;
        };

        Date orderDate = new Date();

        String orderStatus = OrderStatus.未支付.getStatus();

        Double accountPayable = 0d;
        Order order = new Order(orderId,user.getUserId(),passenger.getPassengerIDcard(),passenger.getPassengerName()
        ,orderDate,orderStatus,mealsOrder.getMealsName(),mealsOrder.getMealsPrice(),accountPayable);

        orderService.saveOrder(order);

        request.getRequestDispatcher("user/pay.jsp").forward(request,response);
        return null;
    }
}
