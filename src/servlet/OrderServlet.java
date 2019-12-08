package servlet;

import pojo.Passenger;
import pojo.User;
import pojo.order.MealsOrder;
import pojo.order.Order;
import pojo.order.OrderStatus;
import service.impl.OrderServiceImpl;
import web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
@WebServlet(name = "OrderServlet",urlPatterns = "/OrderServlet")
public class OrderServlet extends BaseServlet {
    private OrderServiceImpl orderService = new OrderServiceImpl();
    public String toBooking(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        request.getRequestDispatcher("booking/booking.jsp").forward(request,response);
        return null;
    }
    public String booking(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String orderId = Integer.toString(request.getSession().getAttribute("user").hashCode()+request.getSession().hashCode());
        User user = (User)request.getSession().getAttribute("user");
        Passenger passenger = new Passenger();
        passenger.setPassengerIDcard(request.getParameter("passengerIDcard"));
        passenger.setPassengerName(request.getParameter("passengerIDcard"));
        Date orderDate = new Date();
        OrderStatus orderStatus = null;
        MealsOrder mealsOrder = null;
        Double accountPayable = null;
        Order order = new Order(orderId,user,passenger,orderDate,orderStatus,mealsOrder,accountPayable);
        orderService.saveOrder(order);
        return null;
    }
}
