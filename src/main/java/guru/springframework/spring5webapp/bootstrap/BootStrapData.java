package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        Author jane = new Author("Jane", "Austen");
        Book sense_and_sensibility = new Book("Sense and Sensibility", "12341234");
        jane.getBooks().add(sense_and_sensibility);
        sense_and_sensibility.getAuthors().add(jane);

        authorRepository.save(jane);
        bookRepository.save(sense_and_sensibility);

        Author bob = new Author("Robert", "Martin");
        Book clean = new Book("Clean Code", "1234512345");
        bob.getBooks().add(clean);
        clean.getAuthors().add(bob);

        authorRepository.save(bob);
        bookRepository.save(clean);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
    }



}
