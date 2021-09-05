package ua.lib.commands.admin;

import ua.lib.commands.Command;
import ua.lib.model.services.UserService;

import javax.servlet.http.HttpServletRequest;

public class DeleteLibrarianCommand  implements Command {
    private UserService userService;

    public DeleteLibrarianCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        int idOfTheDeletingUser = Integer.parseInt(request.getParameter("id"));
        userService.delete(idOfTheDeletingUser);
        return "redirect:/api/librarians";
    }
}
