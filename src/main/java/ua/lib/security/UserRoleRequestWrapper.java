package ua.lib.security;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class UserRoleRequestWrapper extends HttpServletRequestWrapper {

    private String email = null;
    private String role = null;
    private HttpServletRequest realRequest;

    public UserRoleRequestWrapper(String email, String role, HttpServletRequest request) {
        super(request);
        this.email = email;
        this.role = role;
        this.realRequest = request;
    }

    @Override
    public boolean isUserInRole(String role) {
        if (this.role == null) {
            return this.realRequest.isUserInRole(role);
        }
        return this.role.equals(role);
    }

    @Override
    public Principal getUserPrincipal() {
        if (this.email == null) {
            return realRequest.getUserPrincipal();
        }

        return new Principal() {
            @Override
            public String getName() {
                return email;
            }
        };
    }
}