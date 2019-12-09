package servlet;

import pojo.Chain;
import pojo.ChainCarriage;
import pojo.chain_info.SeatType;
import service.ChainCarriageService;
import service.ChainService;
import service.impl.ChainCarriageServiceImpl;
import service.impl.ChainServiceImpl;
import web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "ChainServlet", urlPatterns = "/ChainServlet")
public class ChainServlet extends BaseServlet {
    private ChainService chainService = new ChainServiceImpl();
    private ChainCarriageService carriageService = new ChainCarriageServiceImpl();

    public String addChain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String chainId = request.getParameter("chainId");
        String startStation = request.getParameter("startStation");
        String endStation = request.getParameter("endStation");
        double onePrice = Double.parseDouble(request.getParameter("onePrice"));
        double twoPrice = Double.parseDouble(request.getParameter("twoPrice"));
        double softPrice = Double.parseDouble(request.getParameter("softPrice"));
        double hardPrice = Double.parseDouble(request.getParameter("hardPrice"));

        String dTime = request.getParameter("departureTime");
        dTime = dTime.replace('T', ' ').concat(":00");
        Timestamp departureTime = Timestamp.valueOf(dTime);
        String tTime = request.getParameter("time").concat(":00");
        Time time = Time.valueOf(tTime);
        String carriageNum = request.getParameter("carriageNum");
        Chain chain = new Chain(chainId, startStation, endStation, departureTime, time);
        chainService.addChain(chain);

        String firstId = String.valueOf((int)(Math.random()*1000000));
        HashMap<String,ChainCarriage> chainCarriageHashMap = new HashMap<>();
        ChainCarriage standingCarriage = new ChainCarriage(firstId, SeatType.站票.getType(),SeatType.站票.getNumOfType(),chainId,twoPrice);
        ChainCarriage firstClassCarriage = new ChainCarriage("0",SeatType.一等座.getType(),SeatType.一等座.getNumOfType(),chainId,onePrice);
        ChainCarriage twoClassCarriage = new ChainCarriage("1",SeatType.二等座.getType(),SeatType.二等座.getNumOfType(),chainId,twoPrice);
        ChainCarriage hardCarriage = new ChainCarriage("2",SeatType.硬卧.getType(),SeatType.硬卧.getNumOfType(),chainId,hardPrice);
        ChainCarriage softCarriage = new ChainCarriage("3",SeatType.软卧.getType(),SeatType.软卧.getNumOfType(),chainId,softPrice);
        chainCarriageHashMap.put(SeatType.站票.getType(),standingCarriage);
        chainCarriageHashMap.put(SeatType.一等座.getType(),firstClassCarriage);
        chainCarriageHashMap.put(SeatType.二等座.getType(),twoClassCarriage);
        chainCarriageHashMap.put(SeatType.硬卧.getType(),hardCarriage);
        chainCarriageHashMap.put(SeatType.软卧.getType(),softCarriage);


        if (Integer.parseInt(carriageNum) == 8) {
            carriageService.addChainCarriages(8, chainCarriageHashMap);
        } else if (Integer.parseInt(carriageNum) == 16) {
            carriageService.addChainCarriages(16,chainCarriageHashMap);
        }


        response.sendRedirect("manage/ticket_manage.jsp");
        return null;
    }

    public String showAllChain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showTicket(request);
        request.getRequestDispatcher("manage/ticket_manage.jsp").forward(request, response);
        return null;
    }

    public String deleteChain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ChainId = request.getParameter("chainId");
        chainService.deleteChain(ChainId);
        carriageService.deleteCarriage(ChainId);
        request.getRequestDispatcher("manage/ticket_manage.jsp").forward(request, response);
        return null;
    }

    public String updateChain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String chainId = request.getParameter("chainId");
        String updatedPrice = request.getParameter("updatedPrice");
        String updatedTime = request.getParameter("updatedTime");
        Timestamp time = null;
        if (updatedTime != null) {
            updatedTime = updatedTime.replace('T', ' ').concat(":00");
            time = Timestamp.valueOf(updatedTime);
        }
        Chain chain = chainService.selectChainById(chainId);
        request.setAttribute("chain", chain);
        if (updatedTime == null) request.getRequestDispatcher("manage/modifychain.jsp").forward(request, response);
        if (updatedTime != null) {
            chainService.updateChain(chain.getChainId(), time);
            response.sendRedirect("manage/ticket_manage.jsp");
        }
        return null;
    }

    public String priceMethod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String chainId = request.getParameter("chainId");
        HashMap<String, Double> priceMap = new HashMap<>();
        priceMap.put("一等座", chainService.getPrice("一等座", chainId));
        priceMap.put("二等座", chainService.getPrice("二等座", chainId));
        priceMap.put("软卧", chainService.getPrice("软卧", chainId));
        priceMap.put("硬卧", chainService.getPrice("硬卧", chainId));
        priceMap.put("站票", chainService.getPrice("站票", chainId));
        request.setAttribute("priceMap", priceMap);
        request.getRequestDispatcher("manage/price_operation.jsp").forward(request, response);
        return null;
    }

    public String priceUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double oneSeat = Double.parseDouble(request.getParameter("oneSeat"));
        double twoSeat = Double.parseDouble(request.getParameter("twoSeat"));
        double soft = Double.parseDouble(request.getParameter("soft"));
        double hard = Double.parseDouble(request.getParameter("hard"));
        double left = Double.parseDouble(request.getParameter("left"));
        String chainId = request.getParameter("chainId");
        HashMap<String, Double> priceMap = new HashMap<>();
        priceMap.put("一等座", oneSeat);
        priceMap.put("二等座", twoSeat);
        priceMap.put("软卧", soft);
        priceMap.put("硬卧", hard);
        priceMap.put("站票", left);
        carriageService.updatePrice(priceMap, chainId);
        response.sendRedirect("manage/ticket_manage.jsp");
        return null;
    }

    public String showAllChainForUser(HttpServletRequest request, HttpServletResponse response) throws  ServletException,IOException{
        showTicket(request);
        request.getRequestDispatcher("user/ticket.jsp").forward(request, response);
        return null;
    }

    public String showForBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        String chainId = request.getParameter("chainId");
        Chain chain = chainService.selectChainById(chainId);
        request.setAttribute("chain",chain);
        request.getRequestDispatcher("user/booking.jsp").forward(request,response);
        return null;
    }
    private void showTicket(HttpServletRequest request) {
        ArrayList<Chain> chains = chainService.selectAllChain();
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
        request.setAttribute("chainList", chains);
    }
}
