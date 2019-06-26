package dao.impl;

import dao.BookDao;
import dao.connect.DBConnector;
import dao.impl.selector.GetAllBooksSelector;
import dao.impl.selector.GetAuthorBookByAuthorIdSelector;
import dao.impl.selector.GetBookIdByBookName;
import dao.impl.selector.GetBooksByBookIdSelector;
import dao.impl.setter.BookDeleteSetter;
import dao.impl.setter.BookInsertSetter;
import dao.impl.setter.BookUpdateSetter;
import entity.Book;
import entity.BookAuthor;

import java.util.ArrayList;
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

    @Override
    public List<Book> getBooksByAuthor(long authorName) {
        List<BookAuthor> bookAuthors;
        List<Book> books2, books = new ArrayList<>();
        bookAuthors = db.select(new GetAuthorBookByAuthorIdSelector(authorName));
        for (BookAuthor item : bookAuthors) {
            books2 = db.select(new GetBooksByBookIdSelector(item.getBookId()));
            books.addAll(books2);
        }
        return books;
    }

    @Override
    public long getBookIdByBookName(String bookName) {
        List<Book> books = db.select(new GetBookIdByBookName(bookName));
        return books.get(0).getId();
    }


}