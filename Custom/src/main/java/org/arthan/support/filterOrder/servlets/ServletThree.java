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
        name = "servletThree",
        urlPatterns = "/filterOrder/three"
)
public class ServletThree extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entering ServletThree.doGet()");
        resp.getWriter().write("Servlet Three");
        System.out.println("Leaving ServletThree.doGet()");
    }
}
