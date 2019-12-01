package servlet;

import pojo.Manager;
import service.ManagerService;
import service.impl.ManagerServiceImpl;
import web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ManagerServlet",urlPatterns = "/ManagerServlet")
public class ManagerServlet extends BaseServlet {
    private ManagerService managerService = new ManagerServiceImpl();
    public String managerLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("mid");
        String password = request.getParameter("mpassword");
        Manager manager = managerService.findManagerByIdAndPassword(id,password);
        if(manager != null){
            request.getSession().setAttribute("manager",manager);
            response.sendRedirect("manager_main.jsp");
        }else {
             request.setAttribute("error","登陆失败");
             request.getRequestDispatcher("admin.jsp").forward(request,response);
        }
        return null;
    }
}
