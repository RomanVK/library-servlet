package ua.lib.commands;

import ua.lib.model.entity.Book;
import ua.lib.model.entity.User;
import ua.lib.model.services.BookService;
import ua.lib.security.AppUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CatalogCommand implements Command {
    private BookService bookService;

    public CatalogCommand(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        //prepare users for view
        List<Book> books = bookService.getAll();
        request.setAttribute("books", books);
        //set role for switching
        User loginedUser = AppUtils.getLoginedUser(request.getSession());
        if (loginedUser == null) {
            request.setAttribute("roleLoginedUser", "GUEST");
        } else {
            request.setAttribute("roleLoginedUser", loginedUser.getRole().toString());
        }
        return "/catalog.jsp";
    }
}
