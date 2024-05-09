package gr.thanasisdadakardis.clean_hexagonal_onion.query.author;

import gr.thanasisdadakardis.clean_hexagonal_onion.domain.author.Author;

public record AuthorView (Long id, String name) {
    public AuthorView(Author author) {
        this(author.getId(), author.getFullName());
    }
}
