package dao.impl.selector;

import dao.connect.Selector;
import entity.Book;

import java.sql.ResultSet;

public class GetBooksByAuthorSelector implements Selector<Book> {
    public GetBooksByAuthorSelector(String authorName) {
    }

    @Override
    public String getSql() {
        return null;
    }

    @Override
    public Book convert(ResultSet rs) {
        return null;
    }
}
