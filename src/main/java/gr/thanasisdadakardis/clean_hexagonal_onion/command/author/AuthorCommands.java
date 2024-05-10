package gr.thanasisdadakardis.clean_hexagonal_onion.command.author;

import gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction.author.AuthorFlow;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors/commands")
public class AuthorCommands {

    private final AuthorFlow authorFlow;

    public AuthorCommands(AuthorFlow authorFlow) {
        this.authorFlow = authorFlow;
    }

    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void create(@RequestBody CreateAuthorModel createAuthorModel) {
        authorFlow
                .registerAuthorByName(createAuthorModel.firstName(), createAuthorModel.lastName());
    }
}
