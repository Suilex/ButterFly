package dao;

import entity.Author;

import java.sql.SQLException;
import java.util.List;

public interface AuthorDao {

    //add
    void add(Author author);

    //read
    List<Author> getAll();

    List<Author> getAllByBookId(long bookName);

    void delete(Author author) throws SQLException;

    //update
    void update(Author author) throws SQLException;
}
