package ua.lib.commands;

import ua.lib.model.entity.User;
import ua.lib.model.services.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class LoginCommand implements Command{
    private UserService userService ;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if( email == null || email.equals("") || password == null || password.equals("")  ){
            return "/login.jsp";
        }
        Optional<User> user = userService.login(email);
        if( user.isPresent() && user.get().getPassword().equals(password)){
            request.getSession().setAttribute("user" , user.get());
            System.out.println("User with "+ email +" logged successfully.");//TODO make a logging
            return "redirect:/index.jsp";
        }
        return "/login.jsp";
    }
}
