package gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction.author;

import gr.thanasisdadakardis.clean_hexagonal_onion.domain.author.Author;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthorDomainMapperTest {
    @Test
    void mapToDomain() {
        // given
        var input = new AuthorDTO(1L, "Thanasis", "Dadakaridis");
        var expectedOutput = Author.restore()
                .id(1L)
                .firstName("Thanasis")
                .lastName("Dadakaridis")
                .build();
        // when
        var result = AuthorDomainMapper.mapToDomain(input);
        // then
        assertThat(result).usingRecursiveComparison().isEqualTo(expectedOutput);
    }
}
