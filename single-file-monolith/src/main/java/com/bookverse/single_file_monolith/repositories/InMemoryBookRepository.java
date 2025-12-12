package com.bookverse.single_file_monolith.repositories;

import com.bookverse.single_file_monolith.entities.Book;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryBookRepository implements BookRepository {
    private static final List<Book> books = new ArrayList<>();

    static {
        books.add(new Book(1, "Yazılım Tasarımı ve Mimarisi", "Özal YILDIRIM"));
        books.add(new Book(2, "Tasarım Desenleri", "Erich Gamma"));
        books.add(new Book(3, "Temiz Kod", "Robert C. Martin"));
    }

    @Override
    public Optional<Book> findById(int id) {
        return books.stream().filter(b -> b.getId() == id).findFirst();
    }

    @Override
    public List<Book> findAll() {
        return books;
    }
}
