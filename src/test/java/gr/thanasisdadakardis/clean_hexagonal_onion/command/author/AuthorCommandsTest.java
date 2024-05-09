package gr.thanasisdadakardis.clean_hexagonal_onion.command.author;

import gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction.author.AuthorFlow;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class AuthorCommandsTest {

    @Mock
    private AuthorFlow authorFlow;

    @InjectMocks
    private AuthorCommands authorCommands;

    @Test
    void create() {
        //arrange
        var createAuthorModel = new CreateAuthorModel("Thanasis", "Dadakaridis");
        //act
        authorCommands.create(createAuthorModel);
        //assert
        verify(authorFlow, times(1)).registerAuthorByName("Thanasis", "Dadakaridis");
    }

}