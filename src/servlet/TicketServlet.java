package servlet;

import pojo.Chain;
import pojo.Ticket;
import pojo.User;
import pojo.order.Order;
import pojo.utils.TicketUtil;
import service.ChainService;
import service.OrderService;
import service.TicketService;
import service.impl.ChainServiceImpl;
import service.impl.OrderServiceImpl;
import service.impl.TicketServiceImpl;
import web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "TicketServlet",urlPatterns = "/TicketServlet")
public class TicketServlet extends BaseServlet {
    TicketService ticketService = new TicketServiceImpl();
    ChainService chainService = new ChainServiceImpl();
    OrderService orderService = new OrderServiceImpl();
    public String generateTicket(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String orderId = request.getParameter("orderId");
        String chainId = request.getParameter("chainId");
        double ticketPrice = Double.parseDouble(request.getParameter("ticketPrice"));
        String ticketId = chainId+TicketUtil.getOrderIdByTime();
        Ticket ticket = new Ticket(ticketId,chainId,orderId,ticketPrice);
        ticketService.generateTicket(ticket);
        response.sendRedirect("user/showTicketForUser.jsp");
        return null;
    }

    public String showTicketForUser(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        //获取用户自身所拥有的所有车票
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            response.sendRedirect("index.html");
        }
        List<Ticket> tickets = ticketService.getAllTicketForUser(user.getUserId());
        HashMap<String,Chain> chainHashMap = new HashMap<>();
        HashMap<String,Order> orderHashMap = new HashMap<>();
        for(Ticket ticket:tickets){
            chainHashMap.put(ticket.getChainId(),chainService.selectChainById(ticket.getChainId()));
            orderHashMap.put(ticket.getOrderId(),orderService.getOrderById(ticket.getOrderId()));
        }
        request.setAttribute("orderHashMap",orderHashMap);
        request.setAttribute("tickets",tickets);
        request.setAttribute("chainHashMap",chainHashMap);
        request.getRequestDispatcher("user/showTicketForUser.jsp").forward(request,response);
        return null;
    }

    public String readyForChangeTicket(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        Order order = orderService.getOrderById(request.getParameter("orderId"));
        Ticket ticket = ticketService.getTicketByOrderId(order.getOrderId());
        Chain chain = chainService.selectChainById(ticket.getChainId());
        request.setAttribute("order",order);
        request.setAttribute("ticket",ticket);
        request.setAttribute("chain",chain);
        request.getRequestDispatcher("user/changeTicket.jsp").forward(request,response);
        return null;
    }
}
