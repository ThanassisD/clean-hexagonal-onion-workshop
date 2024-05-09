package gr.thanasisdadakardis.clean_hexagonal_onion.data.author;


import gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction.author.AuthorDTO;

public class AuthorJPAMapper {
    public static AuthorJPA mapToJPA(AuthorDTO author) {
        return AuthorJPA.builder()
                .id(author.id())
                .firstName(author.firstName())
                .lastName(author.lastName())
                .build();
    }
}
