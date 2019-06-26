package dao.impl.selector;

import dao.connect.Selector;
import entity.BookAuthor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAuthorBookByBookIdSelector implements Selector<BookAuthor> {

    private long bookId;

    public GetAuthorBookByBookIdSelector(long bookId) {
        this.bookId = bookId;
    }

    @Override
    public String getSql() {
        return "Select AuthorId from BookAuthor where BookId = ?";
    }

    @Override
    public BookAuthor convert(ResultSet rs) {
        BookAuthor bookAuthor = new BookAuthor();
        try {
            bookAuthor.setAuthorId(rs.getLong("AuthorId"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookAuthor;
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
