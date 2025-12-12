package services;

import com.bookverse.single_file_monolith.entities.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<Book> findBookById(int id);
    List<Book> findAllBooks();
}
