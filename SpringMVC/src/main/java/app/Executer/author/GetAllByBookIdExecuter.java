package app.Executer.author;

import app.connect.Executer;
import app.entity.Author;
import app.entity.Book;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class GetAllByBookIdExecuter implements Executer<List<Author>> {

    private long bookId;

    public GetAllByBookIdExecuter(long bookId) {
        this.bookId = bookId;
    }

    @Override
    public List<Author> execute(Session session) {
        Book book = session.load(Book.class, bookId);
        return new ArrayList<>(book.getAuthorSet());
    }
}
