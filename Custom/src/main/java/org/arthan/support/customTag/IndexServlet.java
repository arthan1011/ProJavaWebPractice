package org.arthan.support.customTag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Артур on 11.08.2015.
 * Next to Ufa.
 */

@WebServlet(
        name = "indexServlet",
        urlPatterns = "/customTag"
)
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("date", new Date());
        request.setAttribute("Calendar", Calendar.getInstance());
        request.setAttribute("instance", Instant.now());

        if (request.getParameter("text") != null) {
            request.setAttribute("shortText", "This is shortText");
            request.setAttribute("longText", "This text is really long and should be cut to 23 characters");
        }

        String view = "text";

        request.getRequestDispatcher("/WEB-INF/jsp/view/customTag/" + view + ".jsp").forward(request, response);
    }
}
