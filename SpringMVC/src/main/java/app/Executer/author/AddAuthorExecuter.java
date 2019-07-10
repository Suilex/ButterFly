package app.Executer.author;

import app.connect.Executer;
import app.entity.Author;
import org.hibernate.Session;

public class AddAuthorExecuter implements Executer<Author> {

    private Author author;

    public AddAuthorExecuter(Author author) {
        this.author = author;
    }

    @Override
    public Author execute(Session session) {
        session.save(author);
        return null;
    }
}
