package org.arthan.support.filters;

import com.google.common.base.Strings;
import org.apache.commons.lang3.time.StopWatch;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;

/**
 * Created by Артур on 17.08.2015.
 * Next to Ufa.
 */
public class RequestLogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Instant time = Instant.now();
        StopWatch timer = new StopWatch();
        try {
            timer.start();
            chain.doFilter(request, response);
        } finally {
            timer.stop();
            HttpServletRequest in = (HttpServletRequest) request;
            HttpServletResponse out = (HttpServletResponse) response;
            String length = out.getHeader("Content-Length");
            if (Strings.isNullOrEmpty(length)) {
                length = "-";
            }
            System.out.println(in.getRemoteAddr() + " - - [" + time + "]" +
                    " \"" + in.getMethod() + " " + in.getRequestURI() + " " +
                    in.getProtocol() + "\" " + out.getStatus() + " " + length +
                    " " + timer);
        }
    }

    @Override
    public void destroy() {

    }
}
