package gr.thanasisdadakardis.clean_hexagonal_onion.data.book;

import gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction.author.AuthorDTO;
import gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction.book.BookDTO;
import gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction.book.BookDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BookDataServiceImpl implements BookDataService {
    private final BookRepository bookRepository;

    public BookDataServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void save(BookDTO bookDTO) {
        var bookJPA = BookJPAMapper
                .mapToJPA(bookDTO);
        bookRepository.save(bookJPA);
    }

    @Override
    public List<BookDTO> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(this::fromJPAtoDTO)
                .toList();
    }

    @Override
    public List<BookDTO> findByPartialTitle(String title) {
        return bookRepository.findByTitleContaining(title).stream()
                .map(this::fromJPAtoDTO)
                .toList();
    }

    @Override
    public BookDTO findById(Long bookId) {
        return bookRepository.findById(bookId)
                .map(this::fromJPAtoDTO)
                .orElseThrow(() -> new RuntimeException(String.format("Book with id %d could not be found!", bookId)));
    }

    private BookDTO fromJPAtoDTO(BookJPA bookJPA) {
        var authorJPA = bookJPA.getAuthor();
        return new BookDTO(
                bookJPA.getId(),
                new AuthorDTO(
                        bookJPA.getAuthor().getId(),
                        bookJPA.getAuthor().getFirstName(),
                        bookJPA.getAuthor().getLastName()
                ),
                bookJPA.getTitle(),
                bookJPA.getGenre(),
                bookJPA.getPublisherId(),
                bookJPA.isPublished(),
                bookJPA.getIsbn(),
                new ArrayList<>()
        );
    }
}
