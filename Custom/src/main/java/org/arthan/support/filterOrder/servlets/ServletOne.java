package org.arthan.support.filterOrder.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Артур on 15.08.2015.
 * Next to Ufa.
 */

@WebServlet(
        name = "servletOne",
        urlPatterns = "/filterOrder/one"
)
public class ServletOne extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entering ServletOne.doGet()");
        resp.getWriter().write("Servlet One");
        System.out.println("Leaving ServletOne.doGet()");
    }
}
