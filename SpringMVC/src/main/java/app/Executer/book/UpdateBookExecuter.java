package app.Executer.book;

import app.connect.Executer;
import app.entity.Author;
import app.entity.Book;
import org.hibernate.Session;

import java.util.Set;

public class UpdateBookExecuter implements Executer<Book> {

    private Book book;
    private long AuthorId;

    public UpdateBookExecuter(Book book, long authorId) {
        this.book = book;
        AuthorId = authorId;
    }

    @Override
    public Book execute(Session session) {
        Book updateAuthor = session.load(Book.class, book.getId());
        updateAuthor.setName(book.getName());
        updateAuthor.setDescription(book.getDescription());
        updateAuthor.setPublished(book.getPublished());
        updateAuthor.setYear(book.getYear());

        if (AuthorId != 0) {
            Set<Author> authorSet = updateAuthor.getAuthorSet();
            authorSet.add(session.load(Author.class, AuthorId));
            updateAuthor.setAuthorSet(authorSet);
        }
        return null;
    }
}
