package ua.lib.commands;

import ua.lib.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;

public class CommandUtility {

    static boolean checkUserIsLogged(HttpServletRequest request, String email) {
        HashSet<String> loggedUsers = (HashSet<String>) request.getSession().getServletContext()
                .getAttribute("loggedUsers");

        if (loggedUsers.stream().anyMatch(email::equals)) {
            return true;
        }
        loggedUsers.add(email);
        request.getSession().getServletContext()
                .setAttribute("loggedUsers", loggedUsers);
        return false;
    }

    static void removeCurrentLoginedUserFromContext(HttpServletRequest request){
        User loginedUser = (User) request.getSession()
                .getAttribute("loginedUser");
        if(loginedUser != null){
            HashSet<String> loggedUsers = (HashSet<String>) request
                    .getSession().getServletContext()
                    .getAttribute("loggedUsers");
            String email = loginedUser.getEmail();
            loggedUsers.remove(email);
            request.getSession().setAttribute("loggedUsers", loggedUsers);
        }
    }
}
