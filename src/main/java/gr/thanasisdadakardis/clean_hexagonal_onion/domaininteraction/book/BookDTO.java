package gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction.book;

import gr.thanasisdadakardis.clean_hexagonal_onion.domain.book.Book;
import gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction.author.AuthorDTO;

import java.util.UUID;

public record BookDTO(Long id, AuthorDTO authorDTO, String title, String genre, UUID publisherId, boolean published,
                      String isbn) {
    public BookDTO(Book book) {
        this(book.getId(), new AuthorDTO(book.getAuthor()), book.getTitle(), book.getGenre().toString(),
                book.getPublisherId(), book.isPublished(), book.getIsbn());
    }
}
