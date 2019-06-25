package dao.impl.setter;

import dao.connect.PreparedStmtSetter;
import entity.BookAuthor;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookAuthorInsertSetter implements PreparedStmtSetter {

    private BookAuthor bookAuthor;

    public BookAuthorInsertSetter(BookAuthor bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getSql() {
        return "Insert into BookAuthor (AuthorId, BookId) values (?, ?)";
    }

    public void setParams(PreparedStatement stmt) throws SQLException {
        stmt.setLong(1, bookAuthor.getAuthorId());
        stmt.setLong(2, bookAuthor.getBookId());

    }
}