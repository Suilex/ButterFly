package dao;

import entity.BookAuthor;

import java.util.List;

public interface BookAuthorDao {

    //add
    void add (BookAuthor bookAuthor);

    //read
    //List<BookAuthor> show ();

    //delete
    void deleteAuthor (BookAuthor bookAuthor);

    void deleteBook (BookAuthor bookAuthor);

    List<BookAuthor> getAll();

    //update
    //void update (BookAuthor bookAuthor);


}
