package gr.thanasisdadakardis.clean_hexagonal_onion.data.author;

import gr.thanasisdadakardis.clean_hexagonal_onion.domain.author.Author;
import gr.thanasisdadakardis.clean_hexagonal_onion.domain.author.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthorServiceImpl implements AuthorService {
    @Override
    public void registerAuthor(Author author) {
        log.info("Registering author: {}", author);
    }
}
