package app.dao;

import app.entity.Author;

import java.util.List;

public interface AuthorDao {

    //add
    void add(Author author);

    //read
    List getAll();

    List<Author> getAllByBookId(long bookId);

    Author getAuthorByAuthorId(long authorId);

    //delete
    void delete(Author author);

    //update
    void update(Author author, long bookId);
}
