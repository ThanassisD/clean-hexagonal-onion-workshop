package gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction.book;

import gr.thanasisdadakardis.clean_hexagonal_onion.domain.book.Book;
import gr.thanasisdadakardis.clean_hexagonal_onion.domain.book.Genre;
import gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction.author.AuthorDomainMapper;

public class BookDomainMapper {
    public static Book mapToDomain(BookDTO bookDTO) {
        return Book.restore()
                .id(bookDTO.id())
                .title(bookDTO.title())
                .author(AuthorDomainMapper.mapToDomain(bookDTO.authorDTO()))
                .genre(Genre.fromString(bookDTO.genre()))
                .published(bookDTO.published())
                .publisherId(bookDTO.publisherId())
                .isbn(bookDTO.isbn())
                .domainEvents(bookDTO.domainEvents())
                .build();
    }
}
