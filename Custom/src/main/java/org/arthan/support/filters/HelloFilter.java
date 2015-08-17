package org.arthan.support.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by Артур on 15.08.2015.
 * Next to Ufa.
 */

@WebFilter(
        filterName = "helloFilter",
        servletNames = {"helloServlet"},
        dispatcherTypes = {DispatcherType.REQUEST}
)
public class HelloFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Hello filter intercepted");

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
