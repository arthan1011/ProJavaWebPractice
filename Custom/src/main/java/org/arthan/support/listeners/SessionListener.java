package org.arthan.support.listeners;

import org.arthan.support.register.SessionRegistry;

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
        SessionRegistry.updateSessionID(event.getSession(), oldSessionId);
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println(date() + ": Session " + se.getSession().getId() + " created");
        SessionRegistry.addSession(se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println(date() + ": Session " + se.getSession().getId() + " destroyed");
        SessionRegistry.removeSession(se.getSession());
    }

    private String date() {
        return simpleDateFormat.format(new Date());
    }
}
