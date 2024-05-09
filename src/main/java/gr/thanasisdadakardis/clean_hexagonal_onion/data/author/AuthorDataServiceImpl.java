package gr.thanasisdadakardis.clean_hexagonal_onion.data.author;

import gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction.author.AuthorDTO;
import gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction.author.AuthorDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AuthorDataServiceImpl implements AuthorDataService {

    private final AuthorRepository authorRepository;

    public AuthorDataServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void save(AuthorDTO authorDTO) {
        var authorJPA = AuthorJPAMapper
                .mapToJPA(authorDTO);
        authorRepository
                .save(authorJPA);
        log.info("Registering author: {}", authorDTO.getFullName());
    }

    @Override
    public List<AuthorDTO> findAllAuthors() {
        var authorsJPA = authorRepository
                .findAll();

        return authorsJPA.stream()
                .map(authorJPA ->
                        new AuthorDTO(
                            authorJPA.getId(),
                            authorJPA.getFirstName(),
                            authorJPA.getLastName()
                        )
                )
                .toList();
    }
}
