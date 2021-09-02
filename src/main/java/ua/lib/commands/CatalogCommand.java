package ua.lib.commands;

import javax.servlet.http.HttpServletRequest;

public class CatalogCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/catalog.jsp";
    }
}
