package ru.library.libraryapp.service;

import org.springframework.stereotype.Service;
import ru.library.libraryapp.entity.Book;
import ru.library.libraryapp.repository.BookRepository;

@Service
public class BookService {

    private BookRepository bookRepo;

    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Book getBookById() {
        Book book = bookRepo.findById(193L);
        book.setAuthorSet(null);
        return book;
    }

}
