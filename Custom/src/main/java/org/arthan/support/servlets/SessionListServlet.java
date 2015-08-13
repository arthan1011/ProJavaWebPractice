package org.arthan.support.servlets;

import org.arthan.support.register.SessionRegistry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Артур on 06.08.2015.
 * Next to Ufa.
 */

@WebServlet(
        name = "sessionListServlet",
        urlPatterns = "/sessions"
)
public class SessionListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("username") == null) {
            response.sendRedirect("login");
            return;
        }

        request.setAttribute("numberOfSessions", SessionRegistry.getNumberOfSessions());
        request.setAttribute("sessionList", SessionRegistry.getAllSessions());
        request.setAttribute("timestamp", System.currentTimeMillis());
        request.getRequestDispatcher("/WEB-INF/jsp/view/sessions.jsp").forward(request, response);
    }
}
