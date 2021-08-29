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

        String email = request.getParameter("email");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String password = request.getParameter("password");

        if( email == null || email.equals("") ||
                first_name == null || first_name.equals("")  ||
                last_name == null || last_name.equals("")  ||
                password == null || password.equals("")){
            return "/registration.jsp";
        }

        try {
            userService.registrationUser(
                    new User(0L, first_name, last_name, email, RoleType.USER, password )
            );
        } catch(RuntimeException re) {
            System.out.println(re.getMessage());//TODO make a logging
            return "/registration.jsp";
        }

        return "redirect:/login.jsp";
    }
}
