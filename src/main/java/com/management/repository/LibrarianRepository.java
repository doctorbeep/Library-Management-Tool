package com.management.repository;

import com.management.entity.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {
    Optional<Librarian> findById(Integer id);

    Optional<Librarian> findByUsername(String username);
}
