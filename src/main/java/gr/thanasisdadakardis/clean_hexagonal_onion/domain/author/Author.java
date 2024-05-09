package gr.thanasisdadakardis.clean_hexagonal_onion.domain.author;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder(builderMethodName = "restore")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Author {
    @Getter
    private Long id;

    @Getter
    private String firstName;

    @Getter
    private String lastName;

    public static Author createAuthor(String firstName, String lastName) {
        return new Author(null, firstName, lastName);
    }
}
