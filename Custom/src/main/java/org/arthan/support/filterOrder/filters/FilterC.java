package org.arthan.support.filterOrder.filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Артур on 15.08.2015.
 * Next to Ufa.
 */
public class FilterC implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Entering Filter FilterC.doFilter()");
        chain.doFilter(request, response);
        System.out.println("Leaving Filter FilterC.doFilter()");
    }

    @Override
    public void destroy() {

    }
}
