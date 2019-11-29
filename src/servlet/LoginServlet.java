package servlet;

import com.mchange.v2.c3p0.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        request.setCharacterEncoding("utf-8");
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        String userId = request.getParameter("userId");
        String userPassword = request.getParameter("userPassword");
        PrintWriter writer = response.getWriter();
        try {
            Connection conn = dataSource.getConnection();
            String sql = "Select * from user_info where userId = ?";
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1,userId);
            ResultSet resultSet = pstat.executeQuery();
            if(resultSet.next()&&resultSet.getString("userId").equals("")){
                writer.println("没有该账户");
            }else if(resultSet.getString("userPassword").equals(userPassword)){
                writer.println("登录成功666");
            }else{
                writer.println("未处理情况");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
