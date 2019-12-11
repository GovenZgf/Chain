package servlet;

import pojo.Chain;
import pojo.Passenger;
import pojo.Ticket;
import pojo.User;
import pojo.order.MealsOrder;
import pojo.order.Order;
import pojo.order.OrderStatus;
import pojo.utils.OrderUtil;
import service.ChainCarriageService;
import service.ChainService;
import service.OrderService;
import service.TicketService;
import service.impl.ChainCarriageServiceImpl;
import service.impl.ChainServiceImpl;
import service.impl.OrderServiceImpl;
import service.impl.TicketServiceImpl;
import web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "OrderServlet", urlPatterns = "/OrderServlet")
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();
    private ChainService chainService = new ChainServiceImpl();
    private TicketService ticketService = new TicketServiceImpl();
    private ChainCarriageService carriageService = new ChainCarriageServiceImpl();

    public String booking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Chain chain = chainService.selectChainById(request.getParameter("chainId"));
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) response.sendRedirect("index.html");

        String orderId = OrderUtil.getOrderIdByTime() + user.getUserId();

        Passenger passenger = new Passenger();
        passenger.setPassengerIDcard(request.getParameter("passengerIDcard"));
        passenger.setPassengerName(request.getParameter("passengerName"));

        MealsOrder mealsOrder = new MealsOrder();
        String mealsName = request.getParameter("mealsOrder");
        mealsOrder.setMealsName(mealsName);
        switch (mealsName) {
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
            default:
                mealsOrder.setMealsPrice(0d);
        }
        ;

        Date orderDate = new Date();

        String orderStatus = OrderStatus.未支付.getStatus();
        String seatType = request.getParameter("seatType");
        double ticketPrice = carriageService.getSeatPrice(chain.getChainId(), seatType);

        //学生票打75折
        String passengerType = request.getParameter("passengerType");
        if (passengerType.equals("学生")) {
            ticketPrice = ticketPrice * 0.75;
        }

        passenger.setPassengerType(passengerType);
        Order order = new Order(orderId, user.getUserId(), passenger.getPassengerIDcard(), passenger.getPassengerName()
                , orderDate,
                orderStatus,
                mealsOrder.getMealsName(),
                mealsOrder.getMealsPrice(),
                ticketPrice,
                ticketPrice + mealsOrder.getMealsPrice());

        orderService.saveOrder(order);
        request.setAttribute("order", order);
        request.setAttribute("chain", chain);
        request.setAttribute("seatType", seatType);
        request.setAttribute("passenger", passenger);
        request.getRequestDispatcher("user/pay.jsp").forward(request, response);
        return null;
    }

    public String confirmPay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //订单状态改变
        String orderId = request.getParameter("orderId");
        Order order = orderService.getOrderById(orderId);
        orderService.updateStatus(orderId, "已支付");
        String seatType = request.getParameter("seatType");
        //座位减一
        String chainId = request.getParameter("chainId");
        carriageService.updateSeatNum(chainId, seatType);
        //转入车票生成
        request.getRequestDispatcher("TicketServlet?method=generateTicket").forward(request, response);
        return null;
    }

    public String refundTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String orderId = request.getParameter("orderId");

        orderService.updateStatus(orderId,OrderStatus.已退票.getStatus());

        request.getRequestDispatcher("user/showTicketForUser.jsp").forward(request,response);
        return null;
    }

    public String changeTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String ticketId = request.getParameter("ticketId");
        String endStation = request.getParameter("endStation");
        String startStation = request.getParameter("startStation");
        String departureTime = request.getParameter("departureTime");
        Ticket ticket = ticketService.getTicketByTicketId(ticketId);
        request.setAttribute("orderId",ticket.getOrderId());
        if(departureTime!=null) {
            Timestamp time = null;
            departureTime = departureTime.replace('T', ' ').concat(":00");
            time = Timestamp.valueOf(departureTime);
            ArrayList<Chain> chains = chainService.selectAllChain();
        }else if(endStation!=null){
            ArrayList<Chain> chains = chainService.selectChainByStation(startStation,endStation);
            HashMap<String, HashMap<String,Integer>> map = new HashMap<>();
            for(Chain chain:chains){
                HashMap<String,Integer> seatMap = new HashMap<>();
                seatMap.put("一等座",carriageService.getSeatNum("一等座",chain.getChainId()));
                seatMap.put("二等座",carriageService.getSeatNum("二等座",chain.getChainId()));
                seatMap.put("硬卧",carriageService.getSeatNum("硬卧",chain.getChainId()));
                seatMap.put("软卧",carriageService.getSeatNum("软卧",chain.getChainId()));
                seatMap.put("站票",carriageService.getSeatNum("站票",chain.getChainId()));
                map.put(chain.getChainId(),seatMap);
            }
            request.getSession().setAttribute("seatNums",map);
            request.setAttribute("chainList",chains);
            request.getRequestDispatcher("user/changeorrefund/changet.jsp").forward(request,response);
        }


        return null;
    }

    public String confirmChange(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        String orderId = request.getParameter("orderId");
        orderService.updateStatus(orderId,OrderStatus.已改签.getStatus());
        Chain chain = chainService.selectChainById(request.getParameter("chainId"));
        request.setAttribute("chain",chain);
        request.getRequestDispatcher("user/changeorrefund/confirmchange.jsp").forward(request,response);
        return null;
    }
}
