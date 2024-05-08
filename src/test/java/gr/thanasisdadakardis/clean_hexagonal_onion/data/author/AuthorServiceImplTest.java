package gr.thanasisdadakardis.clean_hexagonal_onion.data.author;

import gr.thanasisdadakardis.clean_hexagonal_onion.domain.author.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthorServiceImplTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorServiceImpl authorService;

    @Test
    void shoudCallRepository(){
        //when
        authorService.registerAuthor(Author.createAuthor("Thanasis", "Dadakardis"));
        //then
        verify(authorRepository, times(1)).save(assertArg(actual ->
                assertThat(actual).usingRecursiveComparison().isEqualTo(AuthorJPA.builder()
                        .firstName("Thanasis")
                        .lastName("Dadakardis")
                        .build())));
    }
}