package org.arthan.support;

import org.arthan.support.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Hashtable;

/**
 * Created by Артур on 07.08.2015.
 * Next to Ufa.
 */

@WebServlet(
        name = "profileServlet",
        urlPatterns = "/profile"
)
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setUserId(1342L);
        user.setUsername("CoolHachker133");
        user.setFirstName("Vasya");
        user.setLastName("Smi^&h");

        Hashtable<String, Boolean> permissions =  new Hashtable<>();
        permissions.put("user", true);
        permissions.put("moderator", true);
        permissions.put("admin", false);
        user.setPermissions(permissions);

        request.getServletContext().setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/jsp/view/profile/profile.jsp").forward(request, response);
    }
}
