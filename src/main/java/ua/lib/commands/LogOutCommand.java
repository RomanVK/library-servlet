package ua.lib.commands;

import javax.servlet.http.HttpServletRequest;

public class LogOutCommand  implements Command  {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        CommandUtility.removeCurrentLoginedUserFromContext(request);
        return "redirect:/index.jsp";
    }
}
