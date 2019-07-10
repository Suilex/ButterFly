package app.service;

import app.entity.Book;

import java.util.List;

public interface BookService {

    //add
    void add (Book book, long authorId);

    //read
    List getAll();

    List<Book> getAllByAuthorId(long authorId);

    Book getBookByBookId(long bookId);

    //delete
    void delete(Book book);

    //update
    void update (Book book, long authorId);

}