package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "BookingFilter")
public class BookingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //获取请求头中refer字段的值
        String referer = request.getHeader("referer");
        //如果是浏览器直接发来的请求或其他地址的网站转发的请求，则转发到admin.jsp
        if (referer == null || !referer.contains(request.getServerName())) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/ticket.jsp");
            dispatcher.forward(request, response);
        } else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
