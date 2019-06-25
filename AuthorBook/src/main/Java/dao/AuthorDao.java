package dao;

import entity.Author;

import java.sql.SQLException;
import java.util.List;

public interface AuthorDao {

    //add
    void add(Author author);

    //read
   // void Show (Author author, String[] arr) throws SQLException;

    //delete
    void delete(Author author) throws SQLException;

    //update
    void update(Author author) throws SQLException;

    List<Author> getAll();
}
