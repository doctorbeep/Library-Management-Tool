package com.management.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    //no longer used
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/auth/user/welcome")
    public String userWelcome() {
        return "user-welcome";
    }

    //no longer used
    @PreAuthorize("hasRole('LIBRARIAN')")
    @GetMapping("/auth/librarian/welcome")
    public String librarianWelcome() {
        return "librarian-welcome";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/auth/admin/welcome")
    public String adminWelcome() {
        return "admin-welcome";
    }
}
