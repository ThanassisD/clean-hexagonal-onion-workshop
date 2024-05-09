package gr.thanasisdadakardis.clean_hexagonal_onion.query.author;

import gr.thanasisdadakardis.clean_hexagonal_onion.domain.author.Author;
import gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction.author.AuthorDTO;
import gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction.author.AuthorFlow;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthorQueriesTest {

    @Mock
    private AuthorFlow authorFlow;

    @InjectMocks
    private AuthorQueries authorQueries;

    @Test
    void getAll(){
        List<AuthorDTO> mockedListAuthorListResponse = List.of(
                new AuthorDTO(Author.restore()
                        .id(1L)
                        .firstName("Thanasis")
                        .lastName("Dadakardis")
                        .build())
        );
        when(authorFlow.getListOfAllAuthors())
                .thenReturn(mockedListAuthorListResponse);
        List<AuthorView> result = authorQueries.getAllAuthors();
        verify(authorFlow, times(1)).getListOfAllAuthors();
        assertThat(result).containsExactly(new AuthorView(1L, "Thanasis Dadakardis"));
    }

}