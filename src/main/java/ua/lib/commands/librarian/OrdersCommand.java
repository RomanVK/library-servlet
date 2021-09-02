package ua.lib.commands.librarian;

import ua.lib.commands.Command;

import javax.servlet.http.HttpServletRequest;

public class OrdersCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/librarian/orders.jsp";
    }
}
