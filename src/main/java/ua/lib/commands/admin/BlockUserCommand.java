package ua.lib.commands.admin;

import ua.lib.commands.Command;
import ua.lib.model.services.UserService;

import javax.servlet.http.HttpServletRequest;

public class BlockUserCommand implements Command {
    private UserService userService;

    public BlockUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        int idOfTheBlockingUser = Integer.parseInt(request.getParameter("id"));
        userService.block(idOfTheBlockingUser);
        return "redirect:/api/users";
    }
}