package gr.thanasisdadakardis.clean_hexagonal_onion.domain.author;

import java.util.List;

public interface AuthorService {
    void registerAuthor(Author author);

    List<Author> findAllAuthors();
}
