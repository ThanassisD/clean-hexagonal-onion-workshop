package gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction.book;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookFlow {

    private final BookDataService bookDataService;

    public BookFlow(BookDataService bookDataService) {
        this.bookDataService = bookDataService;
    }

    public List<BookDTO> findAllBooks() {
        return bookDataService.findAll();
    }

    public List<BookDTO> findAllBooksWithMatchingTitle(String title) {
        return bookDataService.findByPartialTitle(title);
    }
}
