package com.management.controller;

import com.management.entity.Librarian;
import com.management.entity.Library;
import com.management.exceptions.LibraryNotFoundException;
import com.management.service.BookService;
import com.management.service.LibrarianService;
import com.management.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    private LibrarianService librarianService;

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/librarians")
    public String viewLibrarians(Model model) {
        List<Librarian> librarians = librarianService.getAllLibrarians();
        model.addAttribute("librarians", librarians);
        return "admin-dashboard-librarians";
    }

    @GetMapping("/librarians/add")
    public String showAddLibrarianForm(Model model) {
        List<Library> libraries = libraryService.getAllLibraries();
        model.addAttribute("libraries", libraries);

        model.addAttribute("librarian", new Librarian());
        return "add-librarian";
    }

    @PostMapping("/librarians")
    public String addLibrarian(@ModelAttribute Librarian librarian,
                               @RequestParam Integer libraryId) throws Exception{
        Library library = libraryService.getLibraryById(libraryId)
                .orElseThrow(() -> new LibraryNotFoundException("Library not found with ID: " + libraryId));

        librarian.setLibrary(library);

        librarianService.saveLibrarian(librarian);

        return "redirect:/admin/librarians";
    }

    @GetMapping("/librarians/edit/{id}")
    public String showEditLibrarianForm(@PathVariable Integer id,
                                        Model model) {
        Librarian librarian = librarianService.getLibrarianById(id).orElseThrow(() -> new RuntimeException("Librarian not found"));
        model.addAttribute("librarian", librarian);

        List<Library> libraries = libraryService.getAllLibraries();
        model.addAttribute("libraries", libraries);
        return "edit-librarian";
    }

    @PostMapping("/librarians/{id}")
    public String updateLibrarian(@PathVariable Integer id,
                                  @ModelAttribute Librarian librarianDetails,
                                  @RequestParam(required = false) Integer libraryId) {

        Librarian librarian = librarianService.getLibrarianById(id)
                .orElseThrow(() -> new RuntimeException("Librarian not found"));

        librarian.setUsername(librarianDetails.getUsername());
        librarian.setPassword(librarianDetails.getPassword());
        librarian.setFirstName(librarianDetails.getFirstName());
        librarian.setLastName(librarianDetails.getLastName());
        librarian.setEmail(librarianDetails.getEmail());
        librarian.setPhoneNumber(librarianDetails.getPhoneNumber());

        if (libraryId != null) {
            Library library = libraryService.getLibraryById(libraryId)
                    .orElseThrow(() -> new RuntimeException("Library not found with ID: " + libraryId));
            librarian.setLibrary(library);
        }

        librarianService.saveLibrarian(librarian);

        return "redirect:/admin/librarians";
    }

    @GetMapping("/librarians/delete/{id}")
    public String deleteLibrarian(@PathVariable Integer id) {
        librarianService.deleteLibrarian(id);
        return "redirect:/admin/librarians";
    }

    @GetMapping("/libraries")
    public String viewLibraries(Model model) {
        List<Library> libraries = libraryService.getAllLibraries();
        model.addAttribute("libraries", libraries);
        return "admin-dashboard-libraries";
    }

    @GetMapping("/libraries/add")
    public String showAddLibraryForm(Model model) {
        model.addAttribute("library", new Library());
        return "add-library";
    }

    @PostMapping("/libraries")
    public String addLibrary(@ModelAttribute Library library) {
        libraryService.saveLibrary(library);
        return "redirect:/admin/libraries";
    }

    @GetMapping("/libraries/edit/{id}")
    public String showEditLibraryForm(@PathVariable Integer id,
                                      Model model) throws Exception{
        Library library = libraryService.getLibraryById(id)
                .orElseThrow(() -> new LibraryNotFoundException("Library not found with ID: " + id));
        model.addAttribute("library", library);
        return "edit-library";
    }

    @PostMapping("/libraries/{id}")
    public String updateLibrary(@PathVariable Integer id,
                                @ModelAttribute Library libraryDetails) throws Exception{
        Library library = libraryService.getLibraryById(id)
                .orElseThrow(() -> new LibraryNotFoundException("Library not found with ID: " + id));

        library.setName(libraryDetails.getName());
        library.setCity(libraryDetails.getCity());

        libraryService.saveLibrary(library);
        return "redirect:/admin/libraries";
    }

/*    @GetMapping("/libraries/delete/{id}")
    public String deleteLibrary(@PathVariable Integer id) {
        List<Book> libraryBooks = bookService.getByLibrary(libraryService.getLibraryById(id).orElse(null));
        for(Book book : libraryBooks){
            bookService.deleteBookById(book.getId());
        }
        libraryService.deleteLibrary(id);
        return "redirect:/admin/libraries";
   }*/
}
