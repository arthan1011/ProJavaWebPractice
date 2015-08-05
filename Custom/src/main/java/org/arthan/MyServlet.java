package org.arthan;

import com.google.common.base.Joiner;
import org.apache.commons.collections.MapUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ����� on 01.08.2015.
 * Next to Ufa.
 */
public class MyServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet " + this.getServletName() + " has started");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/plain");

        resp.getWriter().println("<h1>Hi, there!</h1>");

        String parameterMapString = Joiner.on(", ").withKeyValueSeparator(" => ").join(req.getParameterMap());
        resp.getWriter().println(parameterMapString);

        resp.getWriter().println("Content-type: " + req.getContentType());
        resp.getWriter().println("Request URL: " + req.getRequestURL());
        resp.getWriter().println("Request URI: " + req.getRequestURI());
        resp.getWriter().println("Servlet path: " + req.getServletPath());

        resp.getWriter().println("First param is: " + this.getServletContext().getInitParameter("paramOne"));
        resp.getWriter().println("Who is a titan: " + this.getServletContext().getInitParameter("titan"));

        resp.getWriter().println("Databas is: " + this.getServletConfig().getInitParameter("databaseName"));
    }

    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped");
    }
}
