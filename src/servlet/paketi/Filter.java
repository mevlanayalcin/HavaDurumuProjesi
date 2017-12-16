package servlet.paketi;

import hibernate.paketi.Log;
import hibernate.paketi.LogKaydet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@WebFilter(urlPatterns = "*")
public class Filter implements javax.servlet.Filter {
    @Override
    public void init( final FilterConfig filterConfig )
            throws ServletException {
        final String filterParam = filterConfig.getInitParameter("param");

        System.out.println(filterParam);
    }

    @Override
    public void doFilter( final ServletRequest servletRequest,
                          final ServletResponse servletResponse,
                          final FilterChain filterChain )
            throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest)servletRequest;
        final String remote = req.getRemoteAddr();
        StringBuffer reqUrl = req.getRequestURL();
        String re=reqUrl.toString();
        String date=new Date().toString();
        LogKaydet.databaseVeriEkle(new Log(remote,date,re));
        System.out.println("IP adress "+remote+" , Time "+new Date().toString()+" , acces to "+reqUrl);

        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {
        System.out.println("Filter is destroyed..");
    }

}
