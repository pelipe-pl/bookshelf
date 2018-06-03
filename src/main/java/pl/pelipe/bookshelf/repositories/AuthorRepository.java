package pl.pelipe.bookshelf.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.pelipe.bookshelf.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
