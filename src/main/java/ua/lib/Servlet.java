package ua.lib;

import ua.lib.commands.*;
import ua.lib.model.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Servlet extends HttpServlet {
    private static final String regexPatch = ".*/api/";
    private Map<String, Command> commands = new HashMap<>();

    public void init(){
        commands.put("registration", new RegistrationCommand(new UserService()));
        commands.put("login", new LoginCommand(new UserService()));
        commands.put("logout", new LogOutCommand());
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String path = request.getRequestURI();
        path = path.replaceAll( regexPatch, "");
        Command command = commands.getOrDefault(path ,
                (r)->"/index.jsp)");
        String page = command.execute(request);
        if(page.contains("redirect:")){
            response.sendRedirect(page.replace("redirect:", ""));
        }else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}
