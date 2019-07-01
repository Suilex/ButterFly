package dao.impl.selector;

import dao.connect.Selector;
import entity.Author;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAllAuthorSelector implements Selector<Author> {

    @Override
    public String getSql() {
        return "Select * from Author";
    }

    @Override
    public Author convert(ResultSet rs) {
        Author author = new Author();
        try {
            author.setId(rs.getLong("Id"));
            author.setFirstName(rs.getString("FirstName"));
            author.setLastName(rs.getString("LastName"));
            author.setYear(rs.getLong("Year"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return author;
    }

    @Override
    public void setParams(PreparedStatement statement) {
    }
}
