package dao.impl;

import dao.BookAuthorDao;
import dao.connect.DBConnector;
import dao.impl.setter.BookAuthorDeleteAuthorSetter;
import dao.impl.setter.BookAuthorDeleteBookSetter;
import dao.impl.setter.BookAuthorInsertSetter;
import entity.BookAuthor;

public class BookAuthorDaoImpl implements BookAuthorDao {

    private DBConnector db;

    public BookAuthorDaoImpl(DBConnector db) {
        this.db = db;
    }

    public void add(BookAuthor bookAuthor) {
        db.update(new BookAuthorInsertSetter(bookAuthor));
    }

    public void deleteAuthor(BookAuthor bookAuthor) {
        db.update(new BookAuthorDeleteAuthorSetter(bookAuthor));
    }

    public void deleteBook(BookAuthor bookAuthor) {
        db.update(new BookAuthorDeleteBookSetter(bookAuthor));
    }

}