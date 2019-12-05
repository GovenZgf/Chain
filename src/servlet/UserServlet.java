package servlet;

import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;
import web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserServlet",urlPatterns = "/UserServlet")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();
    public String userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String sid = request.getParameter("userId");
        String sPassword = request.getParameter("userPassword");
        User user = userService.findUserByUsernameAndPassword(sid,sPassword);
        if(user!=null){
            request.getSession().setAttribute("user",user);
            response.sendRedirect("showTicket/ticket.jsp");
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
}
