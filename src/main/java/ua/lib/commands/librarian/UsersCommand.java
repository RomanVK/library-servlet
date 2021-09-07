package ua.lib.commands.librarian;

import ua.lib.commands.Command;
import ua.lib.model.entity.User;
import ua.lib.model.services.UserService;
import ua.lib.security.AppUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UsersCommand implements Command {
    private UserService userService;

    public UsersCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        //prepare users for view
        List<User> users = userService.getAllUsers();
        request.setAttribute("users" , users);
        //set role for switching
        User loginedUser = AppUtils.getLoginedUser(request.getSession());
        request.setAttribute("roleLoginedUser",loginedUser.getRole().toString());
        return "/WEB-INF/librarian/users.jsp";
    }
}
