package ua.lib.commands;

import ua.lib.model.entity.User;
import ua.lib.model.services.UserService;
import ua.lib.security.AppUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class LoginCommand implements Command {
    private UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String errorMessage = "error";

        //TODO make better validation for email and password
        if (email == null || email.equals("") || password == null || password.equals("")) {
            errorMessage = "Please input your email and password";
            request.setAttribute("errorMessage", errorMessage);
            return "/login.jsp";
        }

        if (CommandUtility.checkUserIsLogged(request, email)) {
            errorMessage = "User with the same email has been already logged";
            request.setAttribute("errorMessage", errorMessage);
            return "/login.jsp";
        }

        Optional<User> user = userService.login(email);

        if (user.isPresent() && user.get().getPassword().equals(password)) {
            System.out.println("User with " + email + " logged successfully.");//TODO make a logging
            AppUtils.storeLoginedUser(request.getSession(), user.get());
            int redirectId = -1;
            try {
                redirectId = Integer.parseInt(request.getParameter("redirectId"));
            } catch (Exception e) {
            }
            String requestUri = AppUtils.getRedirectAfterLoginUrl(redirectId);
            if (requestUri != null) {
                return (request.getContextPath() + "redirect:" + requestUri);
            } else {
                return (request.getContextPath() + "redirect:/api/profile");
            }
        }
        errorMessage = "Invalid userName or Password";
        request.setAttribute("errorMessage", errorMessage);
        return "/login.jsp";
    }
}
