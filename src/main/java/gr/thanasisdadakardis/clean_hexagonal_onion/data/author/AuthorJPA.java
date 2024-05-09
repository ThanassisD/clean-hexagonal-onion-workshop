package gr.thanasisdadakardis.clean_hexagonal_onion.data.author;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Builder
@NoArgsConstructor()
@AllArgsConstructor
@Table(name = "author")
public class AuthorJPA {

    @Id
    @Getter
    @GeneratedValue(strategy = SEQUENCE, generator = "author_seq_gen")
    @SequenceGenerator(name = "author_seq_gen", sequenceName = "author_seq", allocationSize = 1)
    private Long id;

    @Getter
    private String firstName;

    @Getter
    private String lastName;
}
