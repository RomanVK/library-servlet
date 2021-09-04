package ua.lib.security;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashSet;

public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        //TODO make a separate method for clearing session and context attributes
        HashSet<String> loggedUsers = (HashSet<String>) httpSessionEvent
                .getSession().getServletContext()
                .getAttribute("loggedUsers");
        String email = (String) httpSessionEvent.getSession().getServletContext()
                .getAttribute("email");
        loggedUsers.remove(email);
        httpSessionEvent.getSession().setAttribute("loggedUsers", loggedUsers);
    }
}