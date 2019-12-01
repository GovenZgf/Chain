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
@WebServlet(name = "UserServlet",urlPatterns = "/UserServlet")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();
    public String userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String sid = request.getParameter("userId");
        String spassword = request.getParameter("userPassword");
        User user = userService.findUserByUsernameAndPassword(sid,spassword);
        if(user!=null){
            request.getSession().setAttribute("user",user);
            response.sendRedirect("main.jsp");
        }else {
            request.setAttribute("error","登陆失败");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        return null;
    }
}
