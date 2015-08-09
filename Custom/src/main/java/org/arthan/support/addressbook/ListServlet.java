package org.arthan.support.addressbook;

import com.google.common.collect.Sets;
import org.arthan.support.entity.Contact;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.time.Month;
import java.time.MonthDay;
import java.util.Set;

/**
 * Created by Артур on 09.08.2015.
 * Next to Ufa.
 */

@WebServlet(
        name = "listServlet",
        urlPatterns = {"/list"}
)
public class ListServlet extends HttpServlet {

    private static Set<Contact> contacts;

    public ListServlet() {
        contacts = Sets.newConcurrentHashSet();
        contacts.add(new Contact("Marina", "Gagarina", "Moscow, Kremlin", "99832",
                        MonthDay.of(Month.APRIL, 13), Instant.parse("2013-02-01T21:22:23Z")));
        contacts.add(new Contact("John", "Sanders", "Ave 32", "832-34",
                        MonthDay.of(Month.FEBRUARY, 3), Instant.parse("2003-05-07T21:22:23Z")));
        contacts.add(new Contact("Scott", "Jonson", "63 Elm Street", "832-3244",
                        MonthDay.of(Month.NOVEMBER, 5), Instant.parse("2003-07-12T21:22:23Z")));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        addContactsAttribute(request);

        request.getRequestDispatcher("WEB-INF/jsp/view/addressbook/list.jsp").forward(request, response);
    }

    private void addContactsAttribute(HttpServletRequest request) {
        boolean notEmpty = request.getParameter("empty") == null;
        if(notEmpty) {
            request.setAttribute("contacts", contacts);
        } else {
            request.setAttribute("contacts", Sets.newConcurrentHashSet());
        }
    }
}
