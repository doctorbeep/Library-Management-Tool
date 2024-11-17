package com.management.datainit;

import com.management.entity.*;
import com.management.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
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

        // Books for Central City Library (library1)
        bookRepository.saveAll(List.of(
                new Book("Great Expectations", "Charles Dickens", "9781234567891", library1, LocalDate.of(1861, 1, 1)),
                new Book("Moby-Dick", "Herman Melville", "9781234567892", library1, LocalDate.of(1851, 11, 14)),
                new Book("1984", "George Orwell", "9780451524935", library1, LocalDate.of(1949, 6, 8)),
                new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", library1, LocalDate.of(1925, 4, 10)),
                new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084", library1, LocalDate.of(1960, 7, 11)),
                new Book("The Catcher in the Rye", "J.D. Salinger", "9780316769488", library1, LocalDate.of(1951, 7, 16)),
                new Book("Brave New World", "Aldous Huxley", "9780060850524", library1, LocalDate.of(1932, 1, 1)),
                new Book("War and Peace", "Leo Tolstoy", "9780140447934", library1, LocalDate.of(1869, 1, 1)),
                new Book("The Odyssey", "Homer", "9780140268867", library1, LocalDate.of(-700, 1, 1)),
                new Book("The Iliad", "Homer", "9780140275360", library1, LocalDate.of(-750, 1, 1))
        ));

        // Books for Librarie Panciu (library2)
        bookRepository.saveAll(List.of(
                new Book("Madame Bovary", "Gustave Flaubert", "9780140449129", library2, LocalDate.of(1857, 1, 1)),
                new Book("Les Misérables", "Victor Hugo", "9780140444308", library2, LocalDate.of(1862, 1, 1)),
                new Book("Anna Karenina", "Leo Tolstoy", "9780143035008", library2, LocalDate.of(1877, 1, 1)),
                new Book("Crime and Punishment", "Fyodor Dostoevsky", "9780486415871", library2, LocalDate.of(1866, 1, 1)),
                new Book("The Brothers Karamazov", "Fyodor Dostoevsky", "9780374528379", library2, LocalDate.of(1880, 1, 1)),
                new Book("Middlemarch", "George Eliot", "9780141439549", library2, LocalDate.of(1871, 1, 1)),
                new Book("Don Quixote", "Miguel de Cervantes", "9780060934347", library2, LocalDate.of(1605, 1, 1)),
                new Book("Ulysses", "James Joyce", "9780141182803", library2, LocalDate.of(1922, 1, 1)),
                new Book("Wuthering Heights", "Emily Brontë", "9780141439556", library2, LocalDate.of(1847, 12, 1)),
                new Book("Dracula", "Bram Stoker", "9780141439846", library2, LocalDate.of(1897, 1, 1))
        ));

        // Books for Biblioteca Națională a României (library3)
        bookRepository.saveAll(List.of(
                new Book("The Divine Comedy", "Dante Alighieri", "9780142437223", library3, LocalDate.of(1320, 1, 1)),
                new Book("Gargantua and Pantagruel", "François Rabelais", "9780140445503", library3, LocalDate.of(1532, 1, 1)),
                new Book("Faust", "Johann Wolfgang von Goethe", "9780140449013", library3, LocalDate.of(1808, 1, 1)),
                new Book("The Sorrows of Young Werther", "Johann Wolfgang von Goethe", "9780140445039", library3, LocalDate.of(1774, 1, 1)),
                new Book("Candide", "Voltaire", "9780140440041", library3, LocalDate.of(1759, 1, 1)),
                new Book("Phedre", "Jean Racine", "9780140445923", library3, LocalDate.of(1677, 1, 1)),
                new Book("The Canterbury Tales", "Geoffrey Chaucer", "9780140422344", library3, LocalDate.of(1400, 1, 1)),
                new Book("Beowulf", "Unknown", "9780140449310", library3, LocalDate.of(1000, 1, 1)),
                new Book("The Aeneid", "Virgil", "9780140449327", library3, LocalDate.of(-19, 1, 1)),
                new Book("Leaves of Grass", "Walt Whitman", "9780140421996", library3, LocalDate.of(1855, 1, 1))
        ));

        // Books for Cluj County Library (library4)
        bookRepository.saveAll(List.of(
                new Book("The Art of War", "Sun Tzu", "9780486425573", library4, LocalDate.of(-500, 1, 1)),
                new Book("The Prince", "Niccolò Machiavelli", "9780140449150", library4, LocalDate.of(1532, 1, 1)),
                new Book("The Republic", "Plato", "9780140455113", library4, LocalDate.of(-380, 1, 1)),
                new Book("Meditations", "Marcus Aurelius", "9780486298238", library4, LocalDate.of(180, 1, 1)),
                new Book("The Federalist Papers", "Alexander Hamilton, James Madison, John Jay", "9780140444957", library4, LocalDate.of(1788, 1, 1)),
                new Book("Common Sense", "Thomas Paine", "9780486296029", library4, LocalDate.of(1776, 1, 1)),
                new Book("The Wealth of Nations", "Adam Smith", "9780140432084", library4, LocalDate.of(1776, 3, 9)),
                new Book("Das Kapital", "Karl Marx", "9780140445688", library4, LocalDate.of(1867, 1, 1)),
                new Book("The Rights of Man", "Thomas Paine", "9780486408935", library4, LocalDate.of(1791, 1, 1)),
                new Book("Leviathan", "Thomas Hobbes", "9780140431957", library4, LocalDate.of(1651, 1, 1))
        ));

        // Books for Iași City Library (library5)
        bookRepository.saveAll(List.of(
                new Book("Heart of Darkness", "Joseph Conrad", "9780141441672", library5, LocalDate.of(1899, 1, 1)),
                new Book("Frankenstein", "Mary Shelley", "9780141439471", library5, LocalDate.of(1818, 1, 1)),
                new Book("The Picture of Dorian Gray", "Oscar Wilde", "9780141439570", library5, LocalDate.of(1890, 1, 1)),
                new Book("The Strange Case of Dr. Jekyll and Mr. Hyde", "Robert Louis Stevenson", "9780486266886", library5, LocalDate.of(1886, 1, 1)),
                new Book("The Adventures of Sherlock Holmes", "Arthur Conan Doyle", "9780486474915", library5, LocalDate.of(1892, 1, 1)),
                new Book("Treasure Island", "Robert Louis Stevenson", "9780486275598", library5, LocalDate.of(1883, 1, 1)),
                new Book("Alice's Adventures in Wonderland", "Lewis Carroll", "9780486275437", library5, LocalDate.of(1865, 1, 1)),
                new Book("Through the Looking-Glass", "Lewis Carroll", "9780486275438", library5, LocalDate.of(1871, 1, 1)),
                new Book("Robinson Crusoe", "Daniel Defoe", "9780486457291", library5, LocalDate.of(1719, 1, 1)),
                new Book("Gulliver's Travels", "Jonathan Swift", "9780141439495", library5, LocalDate.of(1726, 1, 1))
        ));

        // Books for Sibiu County Library (library6)
        bookRepository.saveAll(List.of(
                new Book("Pride and Prejudice", "Jane Austen", "9780141439518", library6, LocalDate.of(1813, 1, 28)),
                new Book("Sense and Sensibility", "Jane Austen", "9780141439839", library6, LocalDate.of(1811, 10, 30)),
                new Book("Jane Eyre", "Charlotte Brontë", "9780141441146", library6, LocalDate.of(1847, 10, 16)),
                new Book("Mansfield Park", "Jane Austen", "9780141439808", library6, LocalDate.of(1814, 7, 1)),
                new Book("Emma", "Jane Austen", "9780141439587", library6, LocalDate.of(1815, 12, 25)),
                new Book("Northanger Abbey", "Jane Austen", "9780141439792", library6, LocalDate.of(1817, 12, 1)),
                new Book("Persuasion", "Jane Austen", "9780141439563", library6, LocalDate.of(1817, 12, 20)),
                new Book("The Tenant of Wildfell Hall", "Anne Brontë", "9780141439815", library6, LocalDate.of(1848, 6, 1)),
                new Book("Villette", "Charlotte Brontë", "9780141439464", library6, LocalDate.of(1853, 1, 1)),
                new Book("Agnes Grey", "Anne Brontë", "9780141439648", library6, LocalDate.of(1847, 1, 1))
        ));
    }

}
