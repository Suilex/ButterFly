package app.Executer.book;

import app.connect.Executer;
import app.entity.Author;
import app.entity.Book;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class GetAllByAuthorIdExecuter implements Executer<List<Book>> {

    private long authorId;

    public GetAllByAuthorIdExecuter(long authorId) {
        this.authorId = authorId;
    }

    @Override
    public List<Book> execute(Session session) {
        Author author = session.load(Author.class, authorId);
        return new ArrayList<>(author.getBookSet());
    }
}
