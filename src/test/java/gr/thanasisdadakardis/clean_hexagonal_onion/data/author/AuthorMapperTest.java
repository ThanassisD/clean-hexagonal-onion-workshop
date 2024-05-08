package gr.thanasisdadakardis.clean_hexagonal_onion.data.author;

import gr.thanasisdadakardis.clean_hexagonal_onion.domain.author.Author;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AuthorMapperTest {

    @Test
    void mapToJPA() {
        // Given
        var expected = AuthorJPA.builder()
                .firstName("Thanasis")
                .lastName("Dadakardis")
                .build();
        // When
        var result = AuthorMapper
                .mapToJPA(Author
                        .createAuthor("Thanasis", "Dadakardis")
                );

        assertThat(result)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(expected);
    }

}