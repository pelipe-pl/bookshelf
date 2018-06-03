package pl.pelipe.bookshelf.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.pelipe.bookshelf.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
