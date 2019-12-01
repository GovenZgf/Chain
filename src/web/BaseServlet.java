package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if(method == null||method.equals("")||method.trim().equals("")){
            method = "execute" ;
        }
        //为页面请求匹配具体的处理方法
        Class cla = this.getClass();
        try{
            Method method1 =cla.getMethod(method,HttpServletRequest.class,HttpServletResponse.class);
            if(method1!=null){
                //执行这个方法
                String jspPath = (String)method1.invoke(this,req,resp);
                if(jspPath!=null){
                    //转发
                    req.getRequestDispatcher(jspPath).forward(req,resp);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //默认方法
    public String execute(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        return null;
    }
}
