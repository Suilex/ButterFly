package app.Executer.book;

import app.connect.Executer;
import org.hibernate.Session;

import java.util.List;

public class GetAllExecuter implements Executer<List> {
    @Override
    public List execute(Session session) {
        return session.createQuery("FROM Book").list();
    }
}
