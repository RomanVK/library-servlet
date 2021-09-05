package ua.lib.security;

import ua.lib.model.entity.User;

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
        User loginedUser = (User) httpSessionEvent.getSession()
                .getAttribute("loginedUser");
        String email = loginedUser.getEmail();
        loggedUsers.remove(email);
        httpSessionEvent.getSession().setAttribute("loggedUsers", loggedUsers);
    }
}