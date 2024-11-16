package com.management.datainit;

import com.management.entity.*;
import com.management.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
public class DataInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LibrarianRepository librarianRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private BookRepository bookRepository;

    @PostConstruct
    public void run() {
        // Roles
        Role userRole = new Role();
        userRole.setName("ROLE_USER");
        roleRepository.save(userRole);

        Role librarianRole = new Role();
        librarianRole.setName("ROLE_LIBRARIAN");
        roleRepository.save(librarianRole);

        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");
        roleRepository.save(adminRole);

        // Libraries
        Library library1 = new Library();
        library1.setName("Central City Library");
        library1.setCity("Metropolis");
        libraryRepository.save(library1);

        Library library2 = new Library();
        library2.setName("Librarie Panciu");
        library2.setCity("Panciu");
        libraryRepository.save(library2);

        Library library3 = new Library();
        library3.setName("Biblioteca Națională a României");
        library3.setCity("București");
        libraryRepository.save(library3);

        Library library4 = new Library();
        library4.setName("Cluj County Library");
        library4.setCity("Cluj-Napoca");
        libraryRepository.save(library4);

        Library library5 = new Library();
        library5.setName("Iași City Library");
        library5.setCity("Iași");
        libraryRepository.save(library5);

        Library library6 = new Library();
        library6.setName("Sibiu County Library");
        library6.setCity("Sibiu");
        libraryRepository.save(library6);

        // Admins
        Admin admin1 = new Admin();
        admin1.setEmail("adminemail@gmail.com");
        admin1.setPhoneNumber("0777111999");
        admin1.setFirstName("Cool");
        admin1.setLastName("Admin");
        admin1.setUsername("admin");
        admin1.setPassword(passwordEncoder.encode("password"));
        admin1.setRoles(Set.of(adminRole));
        adminRepository.save(admin1);

        Admin admin2 = new Admin();
        admin2.setEmail("second.admin@gmail.com");
        admin2.setPhoneNumber("0777888999");
        admin2.setFirstName("Second");
        admin2.setLastName("Admin");
        admin2.setUsername("admin2");
        admin2.setPassword(passwordEncoder.encode("password123"));
        admin2.setRoles(Set.of(adminRole));
        adminRepository.save(admin2);

        Admin admin3 = new Admin();
        admin3.setEmail("third.admin@library.org");
        admin3.setPhoneNumber("0766111222");
        admin3.setFirstName("Third");
        admin3.setLastName("Admin");
        admin3.setUsername("admin3");
        admin3.setPassword(passwordEncoder.encode("securepass"));
        admin3.setRoles(Set.of(adminRole));
        adminRepository.save(admin3);

        // Librarians
        Librarian librarian1 = new Librarian();
        librarian1.setFirstName("Mark");
        librarian1.setLastName("Smith");
        librarian1.setEmail("mark.the.librarian@gmail.com");
        librarian1.setPhoneNumber("07221444");
        librarian1.setUsername("best_librarian");
        librarian1.setPassword(passwordEncoder.encode("password"));
        librarian1.setLibrary(library1);
        librarian1.setRoles(Set.of(librarianRole));
        librarianRepository.save(librarian1);

        Librarian librarian2 = new Librarian();
        librarian2.setFirstName("Ioana");
        librarian2.setLastName("Popescu");
        librarian2.setEmail("ioana.librarian@gmail.com");
        librarian2.setPhoneNumber("0744555666");
        librarian2.setUsername("ioana_popescu");
        librarian2.setPassword(passwordEncoder.encode("parola"));
        librarian2.setLibrary(library3);
        librarian2.setRoles(Set.of(librarianRole));
        librarianRepository.save(librarian2);

        Librarian librarian3 = new Librarian();
        librarian3.setFirstName("Alexandru");
        librarian3.setLastName("Holban-Ichim");
        librarian3.setEmail("alexhc@library.com");
        librarian3.setPhoneNumber("0755443322");
        librarian3.setUsername("george_lib");
        librarian3.setPassword(passwordEncoder.encode("libpass"));
        librarian3.setLibrary(library5);
        librarian3.setRoles(Set.of(librarianRole));
        librarianRepository.save(librarian3);

        Librarian librarian4 = new Librarian();
        librarian4.setFirstName("Constantin");
        librarian4.setLastName("Holban-Ichim");
        librarian4.setEmail("costi@library.org");
        librarian4.setPhoneNumber("0799887766");
        librarian4.setUsername("costi");
        librarian4.setPassword(passwordEncoder.encode("safepass"));
        librarian4.setLibrary(library4);
        librarian4.setRoles(Set.of(librarianRole));
        librarianRepository.save(librarian4);

        Librarian librarian5 = new Librarian();
        librarian5.setFirstName("Emanuel");
        librarian5.setLastName("Nechita");
        librarian5.setEmail("emanuelnechita.o7@gmail.com");
        librarian5.setPhoneNumber("0722333444");
        librarian5.setUsername("emi23");
        librarian5.setPassword(passwordEncoder.encode("emanuel"));
        librarian5.setLibrary(library2);
        librarian5.setRoles(Set.of(librarianRole));
        librarianRepository.save(librarian5);

        // Users
        User user1 = new User();
        user1.setFirstName("William");
        user1.setLastName("Shakespeare");
        user1.setEmail("real.will.shakespeare@yahoo.it");
        user1.setPhoneNumber("0711222333");
        user1.setUsername("user");
        user1.setPassword(passwordEncoder.encode("password"));
        user1.setRoles(Set.of(userRole));
        userRepository.save(user1);

        User user2 = new User();
        user2.setFirstName("Mihai");
        user2.setLastName("Eminescu");
        user2.setEmail("mihai.eminescu@gmail.com");
        user2.setPhoneNumber("0733444555");
        user2.setUsername("eminescu");
        user2.setPassword(passwordEncoder.encode("poezie"));
        user2.setRoles(Set.of(userRole));
        userRepository.save(user2);

        User user3 = new User();
        user3.setFirstName("Ion");
        user3.setLastName("Creangă");
        user3.setEmail("ion.creanga@gmail.com");
        user3.setPhoneNumber("0733222111");
        user3.setUsername("creanga");
        user3.setPassword(passwordEncoder.encode("amintiri"));
        user3.setRoles(Set.of(userRole));
        userRepository.save(user3);

        User user4 = new User();
        user4.setFirstName("Jane");
        user4.setLastName("Austen");
        user4.setEmail("jane.austen@gmail.com");
        user4.setPhoneNumber("0723445566");
        user4.setUsername("jausten");
        user4.setPassword(passwordEncoder.encode("pride"));
        user4.setRoles(Set.of(userRole));
        userRepository.save(user4);

        // Books
        Book book1 = new Book();
        book1.setTitle("A Tale of Two Cities");
        book1.setAuthor("Charles Dickens");
        book1.setISBN("9781234567890");
        book1.setLibrary(library1);
        book1.setReleaseDate(LocalDate.of(1859, 1, 1));
        bookRepository.save(book1);

        Book book2 = new Book();
        book2.setTitle("Luceafărul");
        book2.setAuthor("Mihai Eminescu");
        book2.setISBN("9786060000000");
        book2.setLibrary(library3);
        book2.setReleaseDate(LocalDate.of(1883, 1, 1));
        bookRepository.save(book2);

        Book book3 = new Book();
        book3.setTitle("Ion");
        book3.setAuthor("Liviu Rebreanu");
        book3.setISBN("9786062223334");
        book3.setLibrary(library3);
        book3.setReleaseDate(LocalDate.of(1920, 1, 1));
        bookRepository.save(book3);

        Book book4 = new Book();
        book4.setTitle("Pride and Prejudice");
        book4.setAuthor("Jane Austen");
        book4.setISBN("9780192833554");
        book4.setLibrary(library2);
        book4.setReleaseDate(LocalDate.of(1813, 1, 28));
        bookRepository.save(book4);

        Book book5 = new Book();
        book5.setTitle("Amintiri din copilărie");
        book5.setAuthor("Ion Creangă");
        book5.setISBN("9789730000000");
        book5.setLibrary(library5);
        book5.setReleaseDate(LocalDate.of(1881, 1, 1));
        bookRepository.save(book5);

        Book book6 = new Book();
        book6.setTitle("Jane Eyre");
        book6.setAuthor("Charlotte Brontë");
        book6.setISBN("9780141441146");
        book6.setLibrary(library6);
        book6.setReleaseDate(LocalDate.of(1847, 10, 16));
        bookRepository.save(book6);

        Book book7 = new Book();
        book7.setTitle("Enigma Otiliei");
        book7.setAuthor("George Călinescu");
        book7.setISBN("9789732200000");
        book7.setLibrary(library4);
        book7.setReleaseDate(LocalDate.of(1938, 1, 1));
        bookRepository.save(book7);
    }

}
