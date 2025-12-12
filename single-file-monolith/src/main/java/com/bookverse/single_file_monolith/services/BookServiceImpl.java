package com.bookverse.single_file_monolith.services;

import com.bookverse.single_file_monolith.entities.Book;
import com.bookverse.single_file_monolith.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<Book> findBookById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Kitap ID'si pozitif bir değer olmalıdır.");
        }
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }
}