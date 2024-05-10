package gr.thanasisdadakardis.clean_hexagonal_onion.query.book;

import gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction.author.AuthorDTO;
import gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction.book.BookDTO;

public record BookView(String title, String genre, String authorName) {
    public BookView(BookDTO bookDTO, AuthorDTO authorDTO) {
        this(bookDTO.title(), bookDTO.genre(), authorDTO.getFullName());
    }
}
