package gr.thanasisdadakardis.clean_hexagonal_onion.domain.author;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Author {
    private Long id;

    private String firstName;

    private String lastName;

    public static Author createAuthor(String firstName, String lastName) {
        return new Author(null, firstName, lastName);
    }
}
