package app.Executer.book;

import app.connect.Executer;
import app.entity.Book;
import org.hibernate.Session;

public class DeleteBookExecuter implements Executer<Book> {

    private Book book;

    public DeleteBookExecuter(Book book) {
        this.book = book;
    }

    @Override
    public Book execute(Session session) {
        book = session.load(Book.class, book.getId());
        session.delete(book);
        return null;
    }
}
