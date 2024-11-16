package com.management.service;

import com.management.entity.Book;
import com.management.entity.Library;
import com.management.exceptions.LibraryNotFoundException;
import com.management.repository.BookRepository;
import com.management.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private LibraryRepository libraryRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Integer id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book, Integer libraryId) throws LibraryNotFoundException {
        if (libraryId != null) {
            Library library = libraryRepository.findById(libraryId)
                    .orElseThrow(() -> new LibraryNotFoundException("Library with ID: " + libraryId + " not found."));
            book.setLibrary(library);
        }

        return bookRepository.save(book);
    }

    public List<Book> getByLibrary(Library library) {
        return bookRepository.findByLibrary(library);
    }

    public void deleteBookById(Integer id) {
        bookRepository.deleteById(id);
    }
}
