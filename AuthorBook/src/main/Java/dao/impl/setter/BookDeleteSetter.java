package dao.impl.setter;

import dao.connect.PreparedStmtSetter;
import entity.Book;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDeleteSetter implements PreparedStmtSetter {

    private Book book;

    public BookDeleteSetter(Book book) {
        this.book = book;
    }

    public String getSql() {
        return "delete from Book where Id = ?";
    }

    public void setParams(PreparedStatement stmt) throws SQLException {
        stmt.setLong(1, book.getId());
    }
}