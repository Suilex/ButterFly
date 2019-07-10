package app.Executer.book;

import app.connect.Executer;
import app.entity.Book;
import org.hibernate.Session;

public class GetByBookIdExecuter implements Executer<Book> {

    private long bookId;

    public GetByBookIdExecuter(long bookId) {
        this.bookId = bookId;
    }

    @Override
    public Book execute(Session session) {
        Book book = new Book();
        session.load(book, bookId);
        return book;
    }
}
