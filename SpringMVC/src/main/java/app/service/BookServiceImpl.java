package app.service;

import app.dao.BookDao;
import app.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    public BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void add(Book book, long authorId) {
        bookDao.add(book, authorId);
    }

    @Override
    public List getAll() {
        return bookDao.getAll();
    }

    @Override
    public List<Book> getAllByAuthorId(long authorId) {
        return bookDao.getAllByAuthorId(authorId);
    }

    @Override
    public Book getBookByBookId(long bookId) {
        return bookDao.getBookByBookId(bookId);
    }

    @Override
    public void delete(Book book) {
        bookDao.delete(book);
    }

    @Override
    public void update(Book book, long authorId) {
        bookDao.update(book, authorId);
    }
}
