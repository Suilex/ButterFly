package app.connect;

import org.hibernate.Session;

public interface Executer<T> {
    T execute(Session session);
}
