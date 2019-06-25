package dao.impl.setter;

import dao.connect.PreparedStmtSetter;
import entity.Author;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorDeleteSetter implements PreparedStmtSetter {

    private Author author;

    public AuthorDeleteSetter(Author author) {
        this.author = author;
    }

    public String getSql() {
        return "delete from Author where Id = ?";
}

    public void setParams(PreparedStatement stmt) throws SQLException {
        stmt.setLong(1, author.getId());
    }
}