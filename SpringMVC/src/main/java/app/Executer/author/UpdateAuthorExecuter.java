package app.Executer.author;

import app.connect.Executer;
import app.entity.Author;
import app.entity.Book;
import org.hibernate.Session;

import java.util.Set;

public class UpdateAuthorExecuter implements Executer<Author> {

    private Author author;
    private long bookId;

    public UpdateAuthorExecuter(Author author, long bookId) {
        this.author = author;
        this.bookId = bookId;
    }

    @Override
    public Author execute(Session session) {
        Author updateAuthor = session.load(Author.class, author.getId());
        updateAuthor.setFirstName(author.getFirstName());
        updateAuthor.setLastName(author.getLastName());
        updateAuthor.setYear(author.getYear());

        if (bookId != 0) {
           // Set<Book> authorSet = updateAuthor.getBookSet();
           // authorSet.add(session.load(Book.class, bookId);
           // updateAuthor.setBookSet(authorSet);

            Book book = session.load(Book.class, bookId);
            Set<Author> authorSet = book.getAuthorSet();
            authorSet.add(session.load(Author.class, author.getId()));
            book.setAuthorSet(authorSet);
        }
        return null;
    }
}
