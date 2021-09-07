package ua.lib.commands.admin;

import ua.lib.commands.Command;
import ua.lib.model.services.UserService;

import javax.servlet.http.HttpServletRequest;

public class UnblockUserCommand implements Command {
    private UserService userService;

    public UnblockUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        int idOfTheUnblockingUser = Integer.parseInt(request.getParameter("id"));
        userService.unblock(idOfTheUnblockingUser);
        return "redirect:/api/users";
    }
}