package app.dao.impl;

import app.Executer.author.*;
import app.connect.HibernateConnector;
import app.dao.AuthorDao;
import app.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorDaoImpl implements AuthorDao {

    private HibernateConnector hc;

    @Autowired
    public AuthorDaoImpl(HibernateConnector hc) {
        this.hc = hc;
    }

    @Override
    public void add(Author author) {
        hc.execute(new AddAuthorExecuter(author));
    }

    @Override
    public void delete(Author author) {
        hc.execute(new DeleteAuthorExecuter(author));
    }

    @Override
    public void update(Author author, long bookId) {
        hc.execute(new UpdateAuthorExecuter(author, bookId));
    }

    @Override
    public List getAll() {
        return hc.execute(new GetAllExecuter());
    }

    @Override
    public List<Author> getAllByBookId(long bookId) {
        return hc.execute(new GetAllByBookIdExecuter(bookId));
    }

    @Override
    public Author getAuthorByAuthorId(long authorId) {
        return hc.execute(new GetByAuthorIdExecuter(authorId));
    }
}
