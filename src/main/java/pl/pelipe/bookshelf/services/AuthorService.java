package pl.pelipe.bookshelf.services;

import org.springframework.stereotype.Service;
import pl.pelipe.bookshelf.model.Author;
import pl.pelipe.bookshelf.repositories.AuthorRepository;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Iterable<Author> find() {
        return authorRepository.findAll();
    }
}
