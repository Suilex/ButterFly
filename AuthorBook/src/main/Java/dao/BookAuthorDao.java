package dao;

import entity.BookAuthor;

public interface BookAuthorDao {

    //add
    void add (BookAuthor bookAuthor);

    //delete
    void deleteAuthor (BookAuthor bookAuthor);

    void deleteBook (BookAuthor bookAuthor);

}
