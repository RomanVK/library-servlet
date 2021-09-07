package ua.lib.commands;

import ua.lib.model.entity.RoleType;
import ua.lib.model.entity.User;
import ua.lib.model.services.UserService;

import javax.servlet.http.HttpServletRequest;

public class RegistrationCommand implements Command  {
    private UserService userService;

    public RegistrationCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        if(CommandUtility.AreTheUserDataValid(request)){
            CommandUtility.setErrorMessage(request, "The user data are invalid");
            return "/registration.jsp";
        }

        try {
            userService.registrationUser(
                    new User(
                            0L,
                            request.getParameter("first_name"),
                            request.getParameter("last_name"),
                            request.getParameter("email"),
                            RoleType.USER,
                            request.getParameter("password"),
                            false
                    )
            );
        } catch(RuntimeException re) {
            System.out.println(re.getMessage());//TODO make a logging
            CommandUtility.setErrorMessage(request, re.getMessage());
            return "/registration.jsp";
        }

        return "redirect:/login.jsp";
    }
}
