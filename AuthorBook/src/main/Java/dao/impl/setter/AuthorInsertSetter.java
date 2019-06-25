package dao.impl.setter;

import dao.connect.PreparedStmtSetter;
import entity.Author;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorInsertSetter implements PreparedStmtSetter {

    private Author author;

    public AuthorInsertSetter(Author author) {
        this.author = author;
    }

    public String getSql() {
        return "Insert into Author (FirstName, LastName, Year) values (?, ?, ?)";
    }

    public void setParams(PreparedStatement stmt) throws SQLException {
        stmt.setString(1, author.getFirstName());
        stmt.setString(2, author.getLastName());
        stmt.setLong(3, author.getYear());
    }
}