package dao.impl.selector;

import dao.connect.Selector;
import entity.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetBooksByBookIdSelector implements Selector<Book> {

    private long bookId;

    public GetBooksByBookIdSelector(long bookId) {
        this.bookId = bookId;
    }

    @Override
    public String getSql() {
        return "SELECT * FROM Book where Id = ?";
    }

    @Override
    public Book convert(ResultSet rs) {
        Book book = new Book();
        try {
            book.setId(rs.getLong("Id"));
            book.setName(rs.getString("Name"));
            book.setDescription(rs.getString("Description"));
            book.setPublished(rs.getString("Published"));
            book.setYear(rs.getLong("Year"));
            book.setAuthorId(rs.getLong("AuthorId"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public void setParams(PreparedStatement statement) {
        try {
            statement.setLong(1, bookId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
