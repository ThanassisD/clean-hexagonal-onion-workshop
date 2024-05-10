package gr.thanasisdadakardis.clean_hexagonal_onion.data.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookJPA, Long> {
    List<BookJPA> findByTitleContaining(String title);
}
