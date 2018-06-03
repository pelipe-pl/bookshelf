package pl.pelipe.bookshelf.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.pelipe.bookshelf.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
