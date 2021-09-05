package ua.lib.commands.admin;

import ua.lib.commands.Command;
import ua.lib.model.entity.User;
import ua.lib.model.services.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class LibrariansCommand implements Command {
    private UserService userService;

    public LibrariansCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        List<User> librarians = userService.getAllLibrarians();
        request.setAttribute("librarians" , librarians);
        return "/WEB-INF/admin/librarians.jsp";
    }
}
