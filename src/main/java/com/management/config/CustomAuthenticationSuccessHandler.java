package com.management.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        User user = (User) authentication.getPrincipal();

        if (user.getAuthorities().stream().anyMatch(role -> role.getAuthority().equals("ROLE_USER"))) {
            response.sendRedirect("/user/libraries");
        }

        else if (user.getAuthorities().stream().anyMatch(role -> role.getAuthority().equals("ROLE_LIBRARIAN"))) {
            response.sendRedirect("/librarian/library");
        }

        else if (user.getAuthorities().stream().anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"))) {
            response.sendRedirect("/auth/admin/welcome");
        }

    }
}


