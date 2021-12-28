package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher penguin = new Publisher("Penguin","Building no 4 Shelar Park Khadakpada Circle","Kalyan","Maharashtra",421301L);
        publisherRepository.save(penguin);

        Author kathy = new Author("Kathy","Sieera");
        Book ocjp = new Book("Java Programmer Guide","ISBN01");
        kathy.getBooks().add(ocjp);
        ocjp.getAuthors().add(kathy);
        penguin.getBooks().add(ocjp);
        ocjp.setPublisher(penguin);

        authorRepository.save(kathy);
        bookRepository.save(ocjp);


        Publisher rajcomic = new Publisher("Raj Comic","Building no 4 Krishna Park Khadakpada Chowk","Thane","Maharashtra",40001L);
        publisherRepository.save(rajcomic);
        Author mario = new Author("Mario","JoJo");
        Book godfather = new Book("The Godfather","ISBN02");
        mario.getBooks().add(godfather);
        godfather.getAuthors().add(mario);
        godfather.setPublisher(rajcomic);
        rajcomic.getBooks().add(godfather);



        authorRepository.save(mario);

        bookRepository.save(godfather);


        System.out.println("Started in Bootstrap.");
        System.out.println("Number of Books : "+bookRepository.count());
        System.out.println("Number of Author : "+authorRepository.count());
        System.out.println("Number of Publisher : "+publisherRepository.count());
        System.out.println("Details of Publisher: "+publisherRepository.findAll());
    }
}
