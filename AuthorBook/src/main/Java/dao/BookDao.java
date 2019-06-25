package dao;

import entity.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {

    //add
    void add (Book book) throws SQLException;

    //read
   // List<Book> Show ();

    //delete
    void delete(Book book) throws SQLException;

    //update
    void update (Book book) throws SQLException;


    List<Book> getAll();
}
