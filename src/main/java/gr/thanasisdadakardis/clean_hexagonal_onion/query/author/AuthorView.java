package gr.thanasisdadakardis.clean_hexagonal_onion.query.author;

import gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction.author.AuthorDTO;

public record AuthorView (Long id, String name) {
    public AuthorView(AuthorDTO authorDTO) {
        this(authorDTO.id(), authorDTO.getFullName());
    }
}
