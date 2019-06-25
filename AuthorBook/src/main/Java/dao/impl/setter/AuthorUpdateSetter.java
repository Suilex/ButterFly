package dao.impl.setter;

import dao.connect.PreparedStmtSetter;
import entity.Author;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorUpdateSetter implements PreparedStmtSetter {

    private Author author;

    public AuthorUpdateSetter(Author author) {
        this.author = author;
    }

    public String getSql() {
        return "update Author set FirstName = ?, LastName = ?, Year = ? where Id = ?";
    }

    public void setParams(PreparedStatement stmt) throws SQLException {
        stmt.setString(1, author.getFirstName());
        stmt.setString(2, author.getLastName());
        stmt.setLong(3, author.getYear());
        stmt.setLong(4, author.getId());
    }
}