package servlet;

import pojo.Passenger;
import pojo.User;
import service.PassengerService;
import service.UserService;
import service.impl.PassengerServiceImpl;
import service.impl.UserServiceImpl;
import web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "UserServlet",urlPatterns = "/UserServlet")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();
    private PassengerService passengerService = new PassengerServiceImpl();
    public String userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String sid = request.getParameter("userId");
        String sPassword = request.getParameter("userPassword");
        User user = userService.findUserByUsernameAndPassword(sid,sPassword);
        if(user!=null){
            request.getSession().setAttribute("user",user);
            response.sendRedirect("user/ticket.jsp");
        }else {
            request.setAttribute("error","登陆失败");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        return null;
    }
    public String formCheck(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        request.setCharacterEncoding("UTF-8");
        String userId=request.getParameter("userId");
        if("130555".equals(userId)) {
            out.print("<font color='red'>用户名已存在<font>");
        }
        else {
            out.print("该用户名可以注册");
        }
        return null;
    }
    public String userRegister(HttpServletRequest request,HttpServletResponse response) throws ServletException,Exception {
        String sid = request.getParameter("userId");
        String sPassword = request.getParameter("userPassword");
        String sName = request.getParameter("userName");
        String sPhoneNum = request.getParameter("userPhoneNum");
        User user = new User();
        user.setUserId(sid);
        user.setUserPassword(sPassword);
        user.setUserName(sName);
        user.setPhoneNumber(sPhoneNum);
        try {
            userService.saveUser(user);
        }catch (Exception e)
        {
            response.getWriter().println("注册失败！跳转回注册页面");
            response.wait(5000);
            response.sendRedirect("register.jsp");
        }
        response.sendRedirect("index.jsp");
        return null;
    }
    public String showAllUsers(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        ArrayList<User> userList = userService.selectAllUsers();
        ArrayList<Passenger> passengers = new ArrayList<>();
        for(User user:userList) {
            if(passengerService.selectOnePassenger(user.getUserIDCard())!=null)
            passengers.add(passengerService.selectOnePassenger(user.getUserIDCard()));
        }
        request.setAttribute("userList",userList);
        request.setAttribute("passengerList",passengers);
        request.getRequestDispatcher("manage/user_manage.jsp").forward(request,response);
        return null;
    }
    public String deleteOneUser(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String uid = request.getParameter("userId");
        userService.deleteUser(uid);
        request.getRequestDispatcher("manage/user_manage.jsp").forward(request,response);
        return null;
    }
    public String modifyUser(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String passengerIDcard = request.getParameter("passengerIDcard");
        Passenger passenger = passengerService.selectOnePassenger(passengerIDcard);
        if(passenger.getPassengerType().equals("学生")){
        passengerService.updatePassengerType(passengerIDcard,"普通人员");
        response.sendRedirect("manage/user_manage.jsp");}
        else if(passenger.getPassengerType().equals("普通人员")){
            passengerService.updatePassengerType(passengerIDcard,"学生");
            response.sendRedirect("manage/user_manage.jsp");}
        else{
            response.sendRedirect("manage/user_manage.jsp");;
        }
        return null;
    }
}
