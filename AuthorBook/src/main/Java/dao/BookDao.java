package dao;

import entity.Book;

import java.util.List;

public interface BookDao {

    //add
    void add (Book book);

    //read
    List<Book> getAll();

    List<Book> getBooksByAuthor(long authorId);

    long getBookIdByBookName(String bookName);

    //delete
    void delete(Book book);

    //update
    void update (Book book);

}
