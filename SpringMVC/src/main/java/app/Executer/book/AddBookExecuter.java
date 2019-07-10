package app.Executer.book;

import app.connect.Executer;
import app.entity.Author;
import app.entity.Book;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.Set;

public class AddBookExecuter implements Executer<Book> {

    private Book book;
    private long authorId;

    public AddBookExecuter(Book book, long authorId) {
        this.book = book;
        this.authorId = authorId;
    }

    @Override
    public Book execute(Session session) {
        Set<Author> authorSet = new HashSet<>();
        Author author = session.load(Author.class, authorId);
        authorSet.add(author);
        book.setAuthorSet(authorSet);
        session.save(book);
        return null;
    }
}
