package ru.library.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.library.libraryapp.entity.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("Select b.authorSet From Book b Where b.id = 193")
    List<Author> getAuthorSetById();

}
