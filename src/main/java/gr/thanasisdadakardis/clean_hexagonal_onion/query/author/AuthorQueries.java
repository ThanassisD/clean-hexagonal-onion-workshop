package gr.thanasisdadakardis.clean_hexagonal_onion.query.author;

import gr.thanasisdadakardis.clean_hexagonal_onion.domain.author.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/authors")
public class AuthorQueries {

    private final AuthorService authorService;

    public AuthorQueries(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
     public List<AuthorView> getAllAuthors() {
        return authorService.findAllAuthors().stream()
                .map(AuthorView::new)
                .collect(toList());
    }
}
