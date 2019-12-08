package servlet;

import pojo.Chain;
import pojo.ChainCarriage;
import pojo.utils.CarriageType;
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
        CarriageType carriageType = new CarriageType();
        String chainId = request.getParameter("chainId");
        String startStation = request.getParameter("startStation");
        String endStation = request.getParameter("endStation");
        String dTime = request.getParameter("departureTime");
        dTime = dTime.replace('T', ' ').concat(":00");
        Timestamp departureTime = Timestamp.valueOf(dTime);
        String tTime = request.getParameter("time").concat(":00");
        Time time = Time.valueOf(tTime);
        String carriageNum = request.getParameter("carriageNum");
        Chain chain = new Chain(chainId, startStation, endStation, departureTime, time);
        chainService.addChain(chain);
        if (Integer.parseInt(carriageNum) == 8) {
            double[] carriageTypePrice = {Double.parseDouble(request.getParameter("onePrice")),
                    Double.parseDouble(request.getParameter("onePrice")), Double.parseDouble(request.getParameter("twoPrice"))
                    , Double.parseDouble(request.getParameter("twoPrice")), Double.parseDouble(request.getParameter("hardPrice")),
                    Double.parseDouble(request.getParameter("hardPrice")), Double.parseDouble(request.getParameter("softPrice")), Double.parseDouble(request.getParameter("softPrice"))};
            carriageType.setChainCarriages_8(chainId,carriageTypePrice);
            carriageService.addChainCarriages(8, carriageType.chainCarriages_8);
        } else if (Integer.parseInt(carriageNum) == 16) {
            double[] carriageTypePrice = {Double.parseDouble(request.getParameter("onePrice")),
                    Double.parseDouble(request.getParameter("onePrice")),Double.parseDouble(request.getParameter("onePrice")),
                    Double.parseDouble(request.getParameter("onePrice")), Double.parseDouble(request.getParameter("twoPrice"))
                    , Double.parseDouble(request.getParameter("twoPrice")),Double.parseDouble(request.getParameter("twoPrice"))
                    , Double.parseDouble(request.getParameter("twoPrice")), Double.parseDouble(request.getParameter("hardPrice")),
                    Double.parseDouble(request.getParameter("hardPrice")),Double.parseDouble(request.getParameter("hardPrice")),
                    Double.parseDouble(request.getParameter("hardPrice")), Double.parseDouble(request.getParameter("softPrice")), Double.parseDouble(request.getParameter("softPrice")),
                    Double.parseDouble(request.getParameter("softPrice")), Double.parseDouble(request.getParameter("softPrice"))};
            carriageType.setChainCarriages_8(chainId,carriageTypePrice);
            carriageService.addChainCarriages(16,carriageType.chainCarriages_16);
        }


        response.sendRedirect("manage/ticket_manage.jsp");
        return null;
    }
    public String showAllChain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Chain> chains = chainService.selectAllChain();
        ArrayList<ChainCarriage> chainCarriages =carriageService.selectAllChainCarriage(chains);
        int nums[] = new int[chains.size()*5];
        for(int i =0;i<chains.size();i++) {
            for (int n = 0; n < 5; n++) {
                nums[n] = carriageService.getSeatNum(chainCarriages.get(n*2).getCarriageTypes(), chains.get(i).getChainId());
            }
        }
        request.setAttribute("seatNums",nums);
        request.setAttribute("chainList",chains);
        request.getRequestDispatcher("manage/ticket_manage.jsp").forward(request, response);
        return null;
    }
    public String deleteChain(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String ChainId = request.getParameter("chainId");
        chainService.deleteChain(ChainId);
        carriageService.deleteCarriage(ChainId);
        request.getRequestDispatcher("manage/ticket_manage.jsp").forward(request, response);
        return null;
    }
    public String updateChain(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{

        String chainId = request.getParameter("chainId");
        String updatedPrice = request.getParameter("updatedPrice");
        String updatedTime = request.getParameter("updatedTime");
        Timestamp time = null;
        if(updatedTime!=null){
        updatedTime = updatedTime.replace('T', ' ').concat(":00");
        time = Timestamp.valueOf(updatedTime);
        }
        Chain chain = chainService.selectChainById(chainId);
        request.setAttribute("chain",chain);
        if(updatedTime==null) request.getRequestDispatcher("manage/modifychain.jsp").forward(request,response);
        if(updatedTime!=null) {
                chainService.updateChain(chain.getChainId(),time);
                response.sendRedirect("manage/ticket_manage.jsp");
        }
        return null;
    }
    public String priceMethod(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String chainId = request.getParameter("ChainId");
        HashMap<String,Double> priceMap = new HashMap<>();
        priceMap.put("一等座",chainService.getPrice("一等座",chainId));
        priceMap.put("二等座",chainService.getPrice("二等座",chainId));
        priceMap.put("软卧",chainService.getPrice("软卧",chainId));
        priceMap.put("硬卧",chainService.getPrice("硬卧",chainId));
        priceMap.put("站票",chainService.getPrice("站票",chainId));
        request.setAttribute("priceMap",priceMap);
        request.getRequestDispatcher("manage/price_operation.jsp").forward(request,response);
        return null;
    }
    public String priceUpdate(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        double oneSeat = Double.parseDouble(request.getParameter("oneSeat"));
        double twoSeat = Double.parseDouble(request.getParameter("twoSeat"));
        double soft = Double.parseDouble(request.getParameter("soft"));
        double hard = Double.parseDouble(request.getParameter("hard"));
        double left = Double.parseDouble(request.getParameter("left"));
        carriageService.updatePrice(oneSeat,twoSeat,soft,hard,left);
        response.sendRedirect("manage/ticket_manage.jsp");
        return null;
    }
}
