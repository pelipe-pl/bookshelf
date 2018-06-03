package pl.pelipe.bookshelf.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.pelipe.bookshelf.model.Author;
import pl.pelipe.bookshelf.model.Book;
import pl.pelipe.bookshelf.model.Publisher;
import pl.pelipe.bookshelf.repositories.AuthorRepository;
import pl.pelipe.bookshelf.repositories.BookRepository;
import pl.pelipe.bookshelf.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Author janKowalski = new Author("Jan", "Kowalski");
        Publisher theBestPublisher = new Publisher("The best publisher", "Warsaw");
        Book bookOfJava = new Book("The book of Java", "123-123", theBestPublisher);
        janKowalski.getBooks().add(bookOfJava);
        bookOfJava.getAuthors().add(janKowalski);

        authorRepository.save(janKowalski);
        publisherRepository.save(theBestPublisher);
        bookRepository.save(bookOfJava);

        Author adamNowak = new Author("Adam", "Nowak");
        Publisher theVeryGoodPublisher = new Publisher("The very good publisher", "Wroclaw");
        Book bookOfJavaScript = new Book("The book of JavaScript", "321-321", theVeryGoodPublisher);
        adamNowak.getBooks().add(bookOfJavaScript);
        bookOfJavaScript.getAuthors().add(adamNowak);

        authorRepository.save(adamNowak);
        publisherRepository.save(theVeryGoodPublisher);
        bookRepository.save(bookOfJavaScript);
    }
}
