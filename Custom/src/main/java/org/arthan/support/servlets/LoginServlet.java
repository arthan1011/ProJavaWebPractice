package org.arthan.support.servlets;

import com.google.common.collect.Maps;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Артур on 06.08.2015.
 * Next to Ufa.
 */

@WebServlet(
        name = "loginServlet",
        urlPatterns = {"/login"}
)
public class LoginServlet extends HttpServlet {

    private static Map<String, String> userDatabase = Maps.newHashMap();

    public LoginServlet() {
        userDatabase.put("Riko", "riko");
        userDatabase.put("Triela", "triela");
        userDatabase.put("Claese", "claese");
        userDatabase.put("Harriet", "harriet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (checkLogoutCommand(request, response)) return;
        if (checkLogged(request, response)) return;

        request.setAttribute("loginFailed", false);
        request.getRequestDispatcher("/WEB-INF/jsp/view/login.jsp").forward(request, response);
    }

    private boolean checkLogoutCommand(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("logout") != null) {
            request.getSession().invalidate();
            response.sendRedirect("login");
            return true;
        }
        return false;
    }

    private boolean checkLogged(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("username") != null) {
            response.sendRedirect("tickets");
            return true;
        }
        return false;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("username") != null) {
            response.sendRedirect("tickets");
            return;
        }

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean loginFailed = username == null ||
                              password == null ||
                              !LoginServlet.userDatabase.containsKey(username) ||
                              !LoginServlet.userDatabase.get(username).equals(password);

        if (loginFailed) {
            request.setAttribute("loginFailed", true);
            request.getRequestDispatcher("/WEB-INF/jsp/view/login.jsp").forward(request, response);
        } else {
            session.setAttribute("username", username);
            request.changeSessionId();
            response.sendRedirect("tickets");
        }
    }
}
