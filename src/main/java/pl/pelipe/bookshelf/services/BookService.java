package pl.pelipe.bookshelf.services;

import org.springframework.stereotype.Service;
import pl.pelipe.bookshelf.model.Book;
import pl.pelipe.bookshelf.repositories.BookRepository;

@Service
public class BookService {

private BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> find(){
        return bookRepository.findAll();
    }
}
