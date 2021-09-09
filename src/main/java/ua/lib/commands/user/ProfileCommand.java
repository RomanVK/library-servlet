package ua.lib.commands.user;

import ua.lib.commands.Command;
import ua.lib.model.entity.User;
import ua.lib.model.services.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class ProfileCommand implements Command {
    private UserService userService;

    public ProfileCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Optional<User> user = userService.getById(id);
        user.ifPresent(value -> request.setAttribute("user", value));
        return "/WEB-INF/user/profile.jsp";
    }
}
