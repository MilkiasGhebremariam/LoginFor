package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class FileteSERvice implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);



        String path = ( (HttpServletRequest) req).getRequestURI().substring(( (HttpServletRequest) req).getContextPath().length());
        if((( (HttpServletRequest) req).getSession().getAttribute("CurrentUser")!= null) || path.equalsIgnoreCase("/") || path.equalsIgnoreCase("/welcome.jsp") || path.equalsIgnoreCase("/login") ){
            chain.doFilter(req, resp);
        }
        else {
            ((HttpServletRequest)req).getRequestDispatcher("login.jsp").forward(req, resp);
        }
        // pass the request along the filter chain
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
