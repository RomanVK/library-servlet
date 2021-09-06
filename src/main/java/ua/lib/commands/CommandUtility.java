package ua.lib.commands;

import ua.lib.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;

public class CommandUtility {

    public static boolean checkUserIsLogged(HttpServletRequest request, String email) {
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

    public static void removeCurrentLoginedUserFromContext(HttpServletRequest request){
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

    public static boolean AreTheUserDataValid (HttpServletRequest request){
        String email = request.getParameter("email");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String password = request.getParameter("password");

        return email != null && !email.equals("") &&
                first_name != null && !first_name.equals("") &&
                last_name != null && !last_name.equals("") &&
                password != null && !password.equals("");
    }

    public static void setErrorMessage(HttpServletRequest request, String errorMessage) {
        request.setAttribute("errorMessage", errorMessage);
    }

}
