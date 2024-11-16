package com.management.service;

import com.management.entity.Book;
import com.management.entity.Library;
import com.management.repository.BookRepository;
import com.management.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

    public Optional<Library> getLibraryById(Integer id) {
        return libraryRepository.findById(id);
    }

    public List<Book> getBooksByLibrary(Library assignedLibrary) {
        return bookRepository.findByLibrary(assignedLibrary);
    }

    public Library saveLibrary(Library library) {
        return libraryRepository.save(library);
    }

    public void deleteLibrary(Integer id) {
        libraryRepository.deleteById(id);
    }
}
