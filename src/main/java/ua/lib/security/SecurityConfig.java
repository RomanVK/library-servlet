package ua.lib.security;

import ua.lib.model.entity.RoleType;

import java.util.*;

public class SecurityConfig {

    // String: Role
    // List<String>: urlPatterns.
    private static final Map<String, List<String>> mapConfig = new HashMap<>();

    static {
        init();
    }

    private static void init() {
        List<String> AdminUrlPatterns = new ArrayList<>();

        AdminUrlPatterns.add("/api/profile");
        AdminUrlPatterns.add("/api/users");
        AdminUrlPatterns.add("/api/librarians");

        mapConfig.put(RoleType.ADMIN.toString(), AdminUrlPatterns);

        List<String> LibrarianUrlPatterns = new ArrayList<>();

        LibrarianUrlPatterns.add("/api/profile");
        LibrarianUrlPatterns.add("/api/users");
        LibrarianUrlPatterns.add("/api/orders");

        mapConfig.put(RoleType.LIBRARIAN.toString(), LibrarianUrlPatterns);

        List<String> UserUrlPatterns = new ArrayList<>();

        UserUrlPatterns.add("/api/profile");

        mapConfig.put(RoleType.USER.toString(), UserUrlPatterns);
    }

    public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }


}
