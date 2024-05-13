package gr.thanasisdadakardis.clean_hexagonal_onion.data.book;

import gr.thanasisdadakardis.clean_hexagonal_onion.data.author.AuthorJPAMapper;
import gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction.book.BookDTO;

public class BookJPAMapper {
    static BookJPA mapToJPA(BookDTO bookDTO) {
        var bookJPA = BookJPA.builder()
                .id(bookDTO.id())
                .author(AuthorJPAMapper.mapToJPA(bookDTO.authorDTO()))
                .title(bookDTO.title())
                .genre(bookDTO.genre())
                .publisherId(bookDTO.publisherId())
                .published(bookDTO.published())
                .isbn(bookDTO.isbn())
                .build();
        bookJPA.registerDomainEvents(bookDTO.domainEvents());
        return bookJPA;
    }
}
