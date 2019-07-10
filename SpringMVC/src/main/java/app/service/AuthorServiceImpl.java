package app.service;

import app.dao.AuthorDao;
import app.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    public AuthorDao authorDao;

    @Autowired
    public AuthorServiceImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public void add(Author author) {
        authorDao.add(author);
    }

    public List getAll() {
        return authorDao.getAll();
    }

    public List<Author> getAllByBookId(long bookId) {
        return authorDao.getAllByBookId(bookId);
    }

    public Author getAuthorByAuthorId(long authorId) {
        return authorDao.getAuthorByAuthorId(authorId);
    }

    public void delete(Author author) {
        authorDao.delete(author);
    }

    public void update(Author author, long bookId) {
        authorDao.update(author, bookId);
    }
}
