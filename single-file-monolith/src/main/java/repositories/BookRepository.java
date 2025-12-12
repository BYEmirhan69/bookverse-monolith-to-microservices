package repositories;

import com.bookverse.single_file_monolith.entities.Book;
import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Optional<Book> findById(int id);
    List<Book> findAll();
}
