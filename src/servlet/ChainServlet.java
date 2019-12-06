package servlet;

import pojo.Chain;
import service.ChainService;
import service.impl.ChainServiceImpl;
import web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;

@WebServlet(name = "ChainServlet",urlPatterns = "/ChainServlet")
public class ChainServlet extends BaseServlet {
    private ChainService chainService = new ChainServiceImpl();
    public String addChain(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String chainId = request.getParameter("chainId");
        String startStation = request.getParameter("startStation");
        String endStation = request.getParameter("endStation");
        Double price = Double.parseDouble(request.getParameter("chainPrice"));
        String dTime = request.getParameter("departureTime");
        dTime = dTime.replace('T',' ');
        try{
            Timestamp departureTime =Timestamp.valueOf(dTime);
            Time time = Time.valueOf(request.getParameter("time"));
            Chain chain = new Chain(chainId,startStation,endStation,departureTime,time,price);
            chainService.addChain(chain);
        }catch (Exception e){
            e.printStackTrace();
        }
        request.getRequestDispatcher("manage/ticket_manage.jsp").forward(request,response);
        return null;
    }
}
