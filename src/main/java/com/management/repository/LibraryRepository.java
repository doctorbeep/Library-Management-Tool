package com.management.repository;

import com.management.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibraryRepository extends JpaRepository<Library, Integer> {
    Optional<Library> findById(Integer id);
}
