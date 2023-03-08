package eu.javaland.clean_hexagonal_onion.data.author;

import eu.javaland.clean_hexagonal_onion.domaininteraction.author.AuthorDTO;

class AuthorJPAMapper {
    static AuthorJPA mapToJPA(AuthorDTO author){
        return AuthorJPA.builder()
                .id(author.id())
                .firstName(author.firstName())
                .lastName(author.lastName())
                .build();
    }
}
