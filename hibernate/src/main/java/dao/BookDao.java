package dao;

import entity.Book;

import java.util.List;

public interface BookDao {

    //add
    void add (Book book, long authorId);

    //read
    List getAll();

    List<Book> getAllByAuthorId(long authorId);

    //delete
    void delete(Book book);

    //update
    void update (Book book);

}