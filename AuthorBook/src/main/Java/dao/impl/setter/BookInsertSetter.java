package dao.impl.setter;

import dao.connect.PreparedStmtSetter;
import entity.Book;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookInsertSetter implements PreparedStmtSetter {

    private Book book;

    public BookInsertSetter(Book book) {
        this.book = book;
    }

    public String getSql() {
        return "Insert into Book (Name, Description, Published, Year, AuthorId) values (?, ?, ?, ?, ?)";
    }

    public void setParams(PreparedStatement stmt) throws SQLException {
        stmt.setString(1, book.getName());
        stmt.setString(2, book.getDescription());
        stmt.setString(3, book.getPublished());
        stmt.setLong(4, book.getYear());
        stmt.setLong(5, book.getAuthorId());

    }
}