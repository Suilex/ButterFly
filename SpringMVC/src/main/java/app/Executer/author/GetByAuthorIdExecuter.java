package app.Executer.author;

import app.connect.Executer;
import app.entity.Author;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class GetByAuthorIdExecuter implements Executer<Author> {

    private long authorId;


    public GetByAuthorIdExecuter(long authorId) {
        this.authorId = authorId;
    }

    @Override
    public Author execute(Session session) {
        Author author = new Author();
        session.load(author, authorId);
        return author;
    }
}
