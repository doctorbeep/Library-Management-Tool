package com.management.service;

import com.management.entity.Admin;
import com.management.entity.Librarian;
import com.management.entity.User;
import com.management.repository.AdminRepository;
import com.management.repository.LibrarianRepository;
import com.management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LibrarianRepository librarianRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    user.getRoles().stream()
                            .map(role -> new SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toList())
            );
        }

        Librarian librarian = librarianRepository.findByUsername(username).orElse(null);
        if (librarian != null) {
            return new org.springframework.security.core.userdetails.User(
                    librarian.getUsername(),
                    librarian.getPassword(),
                    librarian.getRoles().stream()
                            .map(role -> new SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toList())
            );
        }

        Admin admin = adminRepository.findByUsername(username).orElse(null);
        if (admin != null) {
            return new org.springframework.security.core.userdetails.User(
                    admin.getUsername(),
                    admin.getPassword(),
                    admin.getRoles().stream()
                            .map(role -> new SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toList())
            );
        }

        throw new UsernameNotFoundException("User not found");
    }
}
