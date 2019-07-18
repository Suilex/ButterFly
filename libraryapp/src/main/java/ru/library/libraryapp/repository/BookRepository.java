package ru.library.libraryapp.repository;

import org.springframework.data.jpa.repository.Query;
import ru.library.libraryapp.entity.Author;
import ru.library.libraryapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findById(long BookId);


}
