package gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction.author;

import gr.thanasisdadakardis.clean_hexagonal_onion.domain.author.Author;

public class AuthorDomainMapper {
    public static Author mapToDomain(AuthorDTO authorJPA) {
        return Author.restore()
                .id(authorJPA.id())
                .firstName(authorJPA.firstName())
                .lastName(authorJPA.lastName())
                .build();
    }
}
