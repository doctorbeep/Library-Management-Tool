package com.management.controller;

import com.management.entity.Book;
import com.management.entity.Librarian;
import com.management.entity.Library;
import com.management.exceptions.BookNotFoundException;
import com.management.service.BookService;
import com.management.service.LibrarianService;
import com.management.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/librarian")
@PreAuthorize("hasRole('LIBRARIAN')")
public class LibrarianController {
    @Autowired
    private LibrarianService librarianService;

    @Autowired
    private LibraryService libraryService;

    @Autowired
    private BookService bookService;

    @GetMapping("/library")
    public String viewLibrary(Model model) {
        Optional<Librarian> loggedInLibrarian = librarianService.getLoggedInLibrarian();
        Librarian librarian = loggedInLibrarian.orElse(null);

        if (loggedInLibrarian.isPresent() && librarian.getLibrary() != null) {
            Library assignedLibrary = librarian.getLibrary();
            List<Book> booksInLibrary = libraryService.getBooksByLibrary(assignedLibrary);

            model.addAttribute("library", assignedLibrary);
            model.addAttribute("books", booksInLibrary);

            return "librarian-library";
        }

        model.addAttribute("message", "You are not assigned to any library.");
        return "error";
    }

    @GetMapping("/library/book/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    @PostMapping("/library/book/add")
    public String addBook(@ModelAttribute Book book) throws Exception {
        Optional<Librarian> loggedInLibrarian = librarianService.getLoggedInLibrarian();

        if (loggedInLibrarian.isEmpty() || loggedInLibrarian.get().getLibrary() == null) {
            throw new Exception("You are not authorized to add books because you are not assigned to a library.");
        }

        Library assignedLibrary = loggedInLibrarian.get().getLibrary();

        book.setLibrary(assignedLibrary);

        bookService.saveBook(book, assignedLibrary.getId());

        return "redirect:/librarian/library";
    }

    @GetMapping("/library/book/edit/{id}")
    public String editBook(@PathVariable Integer id, Model model) {
        Optional<Book> bookOptional = bookService.getBookById(id);
        if (bookOptional.isPresent()) {
            model.addAttribute("book", bookOptional.get());
            return "edit-book";
        }
        return "error";
    }

    @PostMapping("/library/book/edit/{id}")
    public String updateBook(@PathVariable Integer id,
                             @ModelAttribute Book bookDetails) throws Exception {

        Book book = bookService.getBookById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with ID: " + id));

        Optional<Librarian> loggedInLibrarian = librarianService.getLoggedInLibrarian();
        if (loggedInLibrarian.isEmpty() || loggedInLibrarian.get().getLibrary() == null) {
            throw new Exception("You are not authorized to edit this book.");
        }

        Library assignedLibrary = loggedInLibrarian.get().getLibrary();
        if (!book.getLibrary().getId().equals(assignedLibrary.getId())) {
            throw new Exception("You are not authorized to edit books outside your assigned library.");
        }

        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setISBN(bookDetails.getISBN());
        book.setReleaseDate(bookDetails.getReleaseDate());

        bookService.saveBook(book, assignedLibrary.getId());

        return "redirect:/librarian/library";
    }
}
