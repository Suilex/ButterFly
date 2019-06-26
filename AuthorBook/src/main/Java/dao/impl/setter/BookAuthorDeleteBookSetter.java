package dao.impl.setter;

import dao.connect.PreparedStmtSetter;
import entity.BookAuthor;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookAuthorDeleteBookSetter implements PreparedStmtSetter {

    private BookAuthor bookAuthor;

    public BookAuthorDeleteBookSetter(BookAuthor bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getSql() {
        return "delete from BookAuthor where BookId = ?";
    }

    public void setParams(PreparedStatement stmt) throws SQLException {
        stmt.setLong(1, bookAuthor.getBookId());
    }
}