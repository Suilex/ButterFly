package app.Executer.author;

import app.connect.Executer;
import app.entity.Author;
import app.entity.Book;
import org.hibernate.Session;

public class DeleteAuthorExecuter implements Executer<Author> {

    private Author author;

    public DeleteAuthorExecuter(Author author) {
        this.author = author;
    }

    @Override
    public Author execute(Session session) {
        author = session.load(Author.class, author.getId());
        for (Book item : author.getBookSet()){
            session.delete(item);
        }
        session.delete(author);
        return null;
    }
}
