package org.arthan.support.register;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by Артур on 06.08.2015.
 * Next to Ufa.
 */
public class SessionRegistry {
    private static final Map<String, HttpSession> SESSIONS = Maps.newHashMap();

    private SessionRegistry() {
    }

    public static void addSession(HttpSession session) {
        SESSIONS.put(session.getId(), session);
    }

    public static void updateSessionID(HttpSession session, String oldSessionID) {
        synchronized (SESSIONS) {
            SESSIONS.remove(oldSessionID);
            addSession(session);
        }
    }

    public static void removeSession(HttpSession session) {
        SESSIONS.remove(session.getId());
    }

    public static List<HttpSession> getAllSessions() {
        return Lists.newArrayList(SESSIONS.values());
    }

    public static int getNumberOfSessions() {
        return SESSIONS.size();
    }
}
