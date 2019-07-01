package dao.impl.selector;

import dao.connect.Selector;
import entity.BookAuthor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAuthorBookByAuthorIdSelector implements Selector<BookAuthor> {

    private long authorId;

    public GetAuthorBookByAuthorIdSelector(long authorId) {
        this.authorId = authorId;
    }

    @Override
    public String getSql() {
        return "Select BookId from BookAuthor where AuthorId = ?";
    }

    @Override
    public BookAuthor convert(ResultSet rs) {
        BookAuthor bookAuthor = new BookAuthor();
        try {
            bookAuthor.setBookId(rs.getLong("BookId"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookAuthor;
    }

    @Override
    public void setParams(PreparedStatement statement) {
        try {
            statement.setLong(1, authorId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
