package dao.impl;

import connect.HibernateConnect;
import dao.AuthorDao;
import entity.Author;
import entity.Book;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class AuthorDaoImpl implements AuthorDao {

    private HibernateConnect hc;

    public AuthorDaoImpl(HibernateConnect hc) {
        this.hc = hc;
    }

    @Override
    public void add(Author author) {
        Session session = hc.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(author);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Author author) {
        Session session = hc.getSessionFactory().openSession();
        session.beginTransaction();

        author = session.load(Author.class, author.getId());
        session.delete(author);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Author author) {
        Session session = hc.getSessionFactory().openSession();
        session.beginTransaction();

        Author updateAuthor = session.load(Author.class, author.getId());
        updateAuthor.setFirstName(author.getFirstName());
        updateAuthor.setLastName(author.getLastName());
        updateAuthor.setYear(author.getYear());

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List getAll() {
        Session session = hc.getSessionFactory().openSession();
        session.beginTransaction();

        List output = session.createQuery("FROM Author").list();

        session.getTransaction().commit();
        session.close();
        return output;
    }

    @Override
    public List<Author> getAllByBookId(long bookId) {
        Session session = HibernateConnect.getSessionFactory().openSession();
        session.beginTransaction();

        Book book = session.load(Book.class, bookId);
        List<Author> authorList = new ArrayList<>(book.getAuthorSet());

        session.getTransaction().commit();
        session.close();
        return authorList;
    }
}
