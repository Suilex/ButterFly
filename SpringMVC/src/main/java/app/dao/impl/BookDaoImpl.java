package app.dao.impl;

import app.Executer.author.DeleteAuthorExecuter;
import app.Executer.author.GetByAuthorIdExecuter;
import app.Executer.book.*;
import app.connect.HibernateConnector;
import app.dao.BookDao;
import app.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookDaoImpl implements BookDao {

    private HibernateConnector hc;

    @Autowired
    public BookDaoImpl(HibernateConnector hc) {
        this.hc = hc;
    }

    @Override
    public void add(Book book, long authorId) {
        hc.execute(new AddBookExecuter(book, authorId));
    }

    @Override
    public void delete(Book book) {
        hc.execute(new DeleteBookExecuter(book));
    }

    @Override
    public void update(Book book, long authorId) {
        hc.execute(new UpdateBookExecuter(book, authorId));
    }

    @Override
    public List getAll() {
        return hc.execute(new GetAllExecuter());
    }

    @Override
    public List<Book> getAllByAuthorId(long authorId) {
        return hc.execute(new GetAllByAuthorIdExecuter(authorId));
    }

    @Override
    public Book getBookByBookId(long bookId) {
        return hc.execute(new GetByBookIdExecuter(bookId));
    }
}