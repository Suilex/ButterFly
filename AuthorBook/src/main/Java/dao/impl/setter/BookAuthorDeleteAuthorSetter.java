package dao.impl.setter;

import dao.connect.PreparedStmtSetter;
import entity.BookAuthor;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookAuthorDeleteAuthorSetter implements PreparedStmtSetter {

    private BookAuthor bookAuthor;

    public BookAuthorDeleteAuthorSetter(BookAuthor bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getSql() {
        return "delete from AuthorBook where AuthorId = ?";
    }

    public void setParams(PreparedStatement stmt) throws SQLException {
        stmt.setLong(1, bookAuthor.getAuthorId());
    }
}