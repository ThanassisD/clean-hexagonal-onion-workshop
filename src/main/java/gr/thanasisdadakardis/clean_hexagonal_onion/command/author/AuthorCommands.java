package gr.thanasisdadakardis.clean_hexagonal_onion.command.author;

import gr.thanasisdadakardis.clean_hexagonal_onion.domain.author.Author;
import gr.thanasisdadakardis.clean_hexagonal_onion.domain.author.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors/commands")
public class AuthorCommands {

    private final AuthorService authorService;

    public AuthorCommands(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void create(@RequestBody CreateAuthorModel createAuthorModel) {
        var author = Author
                .createAuthor(createAuthorModel.firstName(), createAuthorModel.lastName());

        authorService.registerAuthor(author);
    }
}
