package ua.lib.commands.user;

import ua.lib.commands.Command;

import javax.servlet.http.HttpServletRequest;

public class ProfileCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/user/profile.jsp";
    }
}
