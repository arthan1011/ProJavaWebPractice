package org.arthan.support.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Артур on 06.08.2015.
 * Next to Ufa.
 */
@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionIdListener {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");

    @Override
    public void sessionIdChanged(HttpSessionEvent event, String oldSessionId) {
        System.out.println(date() + ": Session ID " + oldSessionId + " was changed to " + event.getSession().getId());
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println(date() + ": Session " + se.getSession().getId() + " created");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println(date() + ": Session " + se.getSession().getId() + " destroyed");
    }

    private String date() {
        return simpleDateFormat.format(new Date());
    }
}
