package gr.thanasisdadakardis.clean_hexagonal_onion.data.book;

import gr.thanasisdadakardis.clean_hexagonal_onion.data.author.AuthorJPA;
import gr.thanasisdadakardis.clean_hexagonal_onion.domain.DomainEvent;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.List;
import java.util.UUID;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class BookJPA extends AbstractAggregateRoot<BookJPA>  {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "book_seq_gen")
    @SequenceGenerator(name = "book_seq_gen", sequenceName = "book_seq", allocationSize = 1)
    @Getter
    private Long id;

    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private AuthorJPA author;

    @Getter
    private String title;

    @Getter
    private String genre;

    @Getter
    private UUID publisherId;

    @Getter
    private boolean published;

    @Getter
    private String isbn;

    public void registerDomainEvents(List<DomainEvent> domainEvents) {
        domainEvents.forEach(this::andEvent);
    }
}