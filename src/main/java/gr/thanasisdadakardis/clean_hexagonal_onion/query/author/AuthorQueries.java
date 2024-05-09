package gr.thanasisdadakardis.clean_hexagonal_onion.query.author;

import gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction.author.AuthorFlow;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/authors")
public class AuthorQueries {

    private final AuthorFlow authorFlow;

    public AuthorQueries(AuthorFlow authorFlow) {
        this.authorFlow = authorFlow;
    }

    @GetMapping
     public List<AuthorView> getAllAuthors() {
        return authorFlow.getListOfAllAuthors()
                .stream()
                .map(AuthorView::new)
                .collect(toList());
    }
}
