package dao.impl;

import dao.connect.DBConnector;
import dao.BookDao;
import dao.impl.selector.GetAllBooksSelector;
import dao.impl.selector.GetBooksByAuthorSelector;
import dao.impl.setter.BookDeleteSetter;
import dao.impl.setter.BookInsertSetter;
import dao.impl.setter.BookUpdateSetter;
import entity.Book;

import java.util.List;

public class BookDaoImpl implements BookDao {

    private DBConnector db;

    public BookDaoImpl(DBConnector db) {
        this.db = db;
    }

    public void add(Book book) {
        db.update(new BookInsertSetter(book));
    }

    public void delete(Book book) {
        db.update(new BookDeleteSetter(book));
    }

    public void update(Book book) {
        db.update(new BookUpdateSetter(book));
    }

    @Override
    public List<Book> getAll() {
        return db.select(new GetAllBooksSelector());
    }

    public List<Book> getAllByAuthor(String authorName) {
        return db.select(new GetBooksByAuthorSelector(authorName));
    }

}