package ua.lib.commands.admin;

import ua.lib.commands.Command;
import ua.lib.commands.CommandUtility;
import ua.lib.model.entity.RoleType;
import ua.lib.model.entity.User;
import ua.lib.model.services.UserService;

import javax.servlet.http.HttpServletRequest;

public class CreateLibrarianCommand implements Command  {
    private UserService userService;

    public CreateLibrarianCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        if(request.getMethod().equals("GET")){
            return "/WEB-INF/admin/createLibrarian.jsp";
        }

        if(!CommandUtility.AreTheUserDataValid(request)){
            CommandUtility.setErrorMessage(request, "The librarian data are invalid");
            return "/WEB-INF/admin/createLibrarian.jsp";
        }

        try {
            userService.registrationUser(
                    new User(
                            0L,
                            request.getParameter("first_name"),
                            request.getParameter("last_name"),
                            request.getParameter("email"),
                            RoleType.LIBRARIAN,
                            request.getParameter("password")
                    )
            );
        } catch(RuntimeException re) {
            System.out.println(re.getMessage());//TODO make a logging
            CommandUtility.setErrorMessage(request, re.getMessage());
            return "/WEB-INF/admin/createLibrarian.jsp";
        }

        return "redirect:/api/librarians";
    }
}
