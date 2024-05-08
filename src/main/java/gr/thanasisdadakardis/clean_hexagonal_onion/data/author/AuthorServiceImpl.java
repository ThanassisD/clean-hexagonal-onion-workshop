package gr.thanasisdadakardis.clean_hexagonal_onion.data.author;

import gr.thanasisdadakardis.clean_hexagonal_onion.domain.author.Author;
import gr.thanasisdadakardis.clean_hexagonal_onion.domain.author.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void registerAuthor(Author author) {
        var authorJPA = AuthorMapper
                .mapToJPA(author);

        authorRepository
                .save(authorJPA);
        log.info("Registering author: {}", author.getFullName());
    }
}
