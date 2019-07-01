package dao.impl;

import connect.HibernateConnect;
import dao.BookDao;
import entity.Author;
import entity.Book;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookDaoImpl implements BookDao {

    private HibernateConnect hc;

    public BookDaoImpl(HibernateConnect hc) {
        this.hc = hc;
    }

    @Override
    public void add(Book book, long authorId) {
        Session session = HibernateConnect.getSessionFactory().openSession();
        session.beginTransaction();

        Set<Author> authorSet = new HashSet<>();
        Author author = session.load(Author.class, authorId);
        authorSet.add(author);
        book.setAuthorSet(authorSet);
        session.save(book);

        Set<Book> bookSet = author.getBookSet();
        bookSet.add(book);
        Author updateAuthor = session.load(Author.class, author.getId());
        updateAuthor.setBookSet(author.getBookSet());

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Book book) {
        Session session = hc.getSessionFactory().openSession();
        session.beginTransaction();

        book = session.load(Book.class, book.getId());
        session.delete(book);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Book book) {
        Session session = hc.getSessionFactory().openSession();
        session.beginTransaction();

        Book updateAuthor = session.load(Book.class, book.getId());
        updateAuthor.setName(book.getName());
        updateAuthor.setDescription(book.getDescription());
        updateAuthor.setPublished(book.getPublished());
        updateAuthor.setYear(book.getYear());

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List getAll() {
        Session session = hc.getSessionFactory().openSession();
        session.beginTransaction();

        List output = session.createQuery("FROM Book").list();

        session.getTransaction().commit();
        session.close();
        return output;
    }

    @Override
    public List<Book> getAllByAuthorId(long authorId) {
        Session session = hc.getSessionFactory().openSession();
        session.beginTransaction();

        Author author = session.load(Author.class, authorId);
        List<Book> bookList = new ArrayList<>(author.getBookSet());

        session.getTransaction().commit();
        session.close();
        return bookList;
    }
}