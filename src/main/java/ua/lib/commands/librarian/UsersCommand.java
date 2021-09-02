package ua.lib.commands.librarian;

import ua.lib.commands.Command;

import javax.servlet.http.HttpServletRequest;

public class UsersCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/librarian/users.jsp";
    }
}
