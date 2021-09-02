package ua.lib.commands.admin;

import ua.lib.commands.Command;

import javax.servlet.http.HttpServletRequest;

public class LibrariansCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/admin/librarians.jsp";
    }
}
