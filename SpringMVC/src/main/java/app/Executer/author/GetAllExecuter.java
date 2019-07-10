package app.Executer.author;

import app.connect.Executer;
import app.entity.Author;
import org.hibernate.Session;

import java.util.List;

public class GetAllExecuter implements Executer<List<Author>> {
    @Override
    public List<Author> execute(Session session) {
        return session.createQuery("FROM Author").list();
    }
}
