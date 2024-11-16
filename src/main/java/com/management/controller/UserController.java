package com.management.controller;

import com.management.entity.Book;
import com.management.entity.Library;
import com.management.service.BookService;
import com.management.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasRole('USER')")
public class UserController {
    @Autowired
    private LibraryService libraryService;

    @Autowired
    private BookService bookService;

    @GetMapping("/libraries")
    public String getAllLibraries(Model model) {
        List<Library> libraries = libraryService.getAllLibraries();
        model.addAttribute("libraries", libraries);
        return "user-select";
    }

    @GetMapping("/library/{id}")
    public String getLibrary(@PathVariable Integer id, Model model) {
        Library library = libraryService.getLibraryById(id).orElse(null);
        List<Book> libraryBooks = bookService.getByLibrary(library);
        model.addAttribute("library", library);
        model.addAttribute("books", libraryBooks);
        return "user-library";
    }

}
