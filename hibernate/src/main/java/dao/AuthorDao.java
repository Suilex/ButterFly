package dao;

import entity.Author;

import java.util.List;

public interface AuthorDao {

    //add
    void add(Author author);

    //read
    List getAll();

    List<Author> getAllByBookId(long bookId);

    //delete
    void delete(Author author);

    //update
    void update(Author author);
}
