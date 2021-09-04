package ua.lib.commands;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;

public class LogOutCommand  implements Command  {
    @Override
    public String execute(HttpServletRequest request) {
        //TODO make a separate method for clearing session and context attributes
        request.getSession().invalidate();
        HashSet<String> loggedUsers = (HashSet<String>) request
                .getSession().getServletContext()
                .getAttribute("loggedUsers");
        String email = (String) request.getSession().getServletContext()
                .getAttribute("email");
        loggedUsers.remove(email);
        request.getSession().setAttribute("loggedUsers", loggedUsers);
        return "redirect:/index.jsp";
    }
}
