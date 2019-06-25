package dao.impl.setter;

import dao.connect.PreparedStmtSetter;
import entity.Book;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookUpdateSetter implements PreparedStmtSetter {

    private Book book;

    public BookUpdateSetter(Book book) {
        this.book = book;
    }

    public String getSql() {
        return "update Book set Name = ?, Description = ?, Published = ?, Year = ?, where Id = ?";
    }

    public void setParams(PreparedStatement stmt) throws SQLException {
        stmt.setString(1, book.getName());
        stmt.setString(2, book.getDescription());
        stmt.setString(3, book.getPublished());
        stmt.setLong(4, book.getYear());
        stmt.setLong(5, book.getId());

    }
}