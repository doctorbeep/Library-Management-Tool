package com.management.service;

import com.management.entity.Librarian;
import com.management.entity.Role;
import com.management.entity.User;
import com.management.repository.LibrarianRepository;
import com.management.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class LibrarianService {
    @Autowired
    private LibrarianRepository librarianRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    public List<Librarian> getAllLibrarians() {
        return librarianRepository.findAll();
    }

    public Optional<Librarian> getLibrarianById(Integer id) {
        return librarianRepository.findById(id);
    }

    public Librarian saveLibrarian(Librarian librarian) {
        String encodedPassword = passwordEncoder.encode(librarian.getPassword());
        librarian.setPassword(encodedPassword);

        Role librarianRole = roleRepository.findByName("ROLE_LIBRARIAN");

        Set<Role> roles = new HashSet<>();
        roles.add(librarianRole);
        librarian.setRoles(roles);

        return librarianRepository.save(librarian);
    }

    public void deleteLibrarian(Integer id) {
        librarianRepository.deleteById(id);
    }

    public Optional<Librarian> getLoggedInLibrarian() {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return librarianRepository.findByUsername(user.getUsername());
    }


}
