package com.management.repository;

import com.management.entity.Book;
import com.management.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findById(Integer id);

    List<Book> findByLibrary(Library library);
}
