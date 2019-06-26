package dao.impl;

import dao.AuthorDao;
import dao.connect.DBConnector;
import dao.impl.selector.GetAllAuthorSelector;
import dao.impl.selector.GetAuthorBookByBookIdSelector;
import dao.impl.selector.GetAuthorsByAuthorIdSelector;
import dao.impl.setter.AuthorDeleteSetter;
import dao.impl.setter.AuthorInsertSetter;
import dao.impl.setter.AuthorUpdateSetter;
import entity.Author;
import entity.BookAuthor;

import java.util.ArrayList;
import java.util.List;

public class AuthorDaoImpl implements AuthorDao {

    private DBConnector db;

    public AuthorDaoImpl(DBConnector db) {
        this.db = db;
    }

    public void add(Author author) {
        db.update(new AuthorInsertSetter(author));
    }

    public void delete(Author author) {
        db.update(new AuthorDeleteSetter(author));
    }

    public void update(Author author) {
        db.update(new AuthorUpdateSetter(author));
    }

    @Override
    public List<Author> getAll() {
        return db.select(new GetAllAuthorSelector());
    }

    @Override
    public List<Author> getAllByBookId(long bookName) {
        List<BookAuthor> bookAuthors;
        List<Author> authors2, authors = new ArrayList<>();
        bookAuthors = db.select(new GetAuthorBookByBookIdSelector(bookName));

        for (BookAuthor item : bookAuthors) {
            authors2 = db.select(new GetAuthorsByAuthorIdSelector(item.getAuthorId()));
            authors.addAll(authors2);
        }

        return authors;
    }
}
