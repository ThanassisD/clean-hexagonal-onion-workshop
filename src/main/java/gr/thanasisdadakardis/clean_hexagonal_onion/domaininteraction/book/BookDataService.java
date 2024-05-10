package gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction.book;

import java.util.List;

public interface BookDataService {
    void save(BookDTO bookDTO);

    List<BookDTO> findAll();

    List<BookDTO> findByPartialTitle(String title);
}
