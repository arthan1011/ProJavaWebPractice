package org.arthan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Артур on 02.08.2015.
 * Next to Ufa.
 */

@WebServlet(
        name = "userServlet",
        urlPatterns = {"/greeting"}
)
public class UserServlet extends HttpServlet {

    private static final String DEFAULT_USER = "Guest";
    private String user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        user = req.getParameter("user");
        if (user == null) {
            user = UserServlet.DEFAULT_USER;
        }

        writePage(resp.getWriter());
    }

    private void writePage(PrintWriter writer) {
        writer.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append(" <head>\r\n")
                .append(" <title>Hello User Application</title>\r\n")
                .append(" </head>\r\n")
                .append(" <body>\r\n")
                .append(" Hello, ").append(user).append("!<br/><br/>\r\n")
                .append(" <form action=\"greeting\" method=\"POST\">\r\n")
                .append(" Enter your name:<br/>\r\n")
                .append(" <input type=\"text\" name=\"user\"/><br/>\r\n")
                .append(" <input type=\"submit\" value=\"Submit\"/>\r\n")
                .append(" </form>\r\n")
                .append(" </body>\r\n")
                .append("</html>\r\n");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
