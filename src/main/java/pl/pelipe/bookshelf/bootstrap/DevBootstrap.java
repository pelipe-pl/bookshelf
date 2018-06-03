package pl.pelipe.bookshelf.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.pelipe.bookshelf.model.Author;
import pl.pelipe.bookshelf.model.Book;
import pl.pelipe.bookshelf.repositories.AuthorRepository;
import pl.pelipe.bookshelf.repositories.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Author janKowalski = new Author("Jan", "Kowalski");
        Book bookOfJava = new Book("The book of Java", "123-123", "The best publisher");
        janKowalski.getBooks().add(bookOfJava);
        bookOfJava.getAuthors().add(janKowalski);

        authorRepository.save(janKowalski);
        bookRepository.save(bookOfJava);

        Author adamNowak = new Author("Adam", "Nowak");
        Book bookOfJavaScript = new Book("The book of JavaScript", "321-321", "Very good publisher");
        adamNowak.getBooks().add(bookOfJavaScript);
        bookOfJavaScript.getAuthors().add(adamNowak);

        authorRepository.save(adamNowak);
        bookRepository.save(bookOfJavaScript);
    }
}
