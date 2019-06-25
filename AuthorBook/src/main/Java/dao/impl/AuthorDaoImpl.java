package dao.impl;

import dao.connect.DBConnector;
import dao.AuthorDao;
import dao.impl.setter.AuthorDeleteSetter;
import dao.impl.setter.AuthorInsertSetter;
import dao.impl.setter.AuthorUpdateSetter;
import entity.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDaoImpl implements AuthorDao {

    private DBConnector db;

    public AuthorDaoImpl(DBConnector db) {
        this.db = db;
    }

    public void add(Author author) {
        db.update(new AuthorInsertSetter(author));
    }

    public void delete(Author author) {
        db.update(new AuthorDeleteSetter(author));
    }

    public void update(Author author) {
        db.update(new AuthorUpdateSetter(author));
    }

    @Override
    public List<Author> getAll() {
        List<Author> authors = new ArrayList<>();
        Connection dbConnection = db.getConnection();
        Statement statement = null;
        try {
            statement = dbConnection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = statement.executeQuery("Select * from Author");
            while (rs.next()) {
                authors.add(getAuthor(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return authors;
    }

    public List<Author> getAllByBookId(int id) {
        List<Author> authors = new ArrayList<>();
        String sql = "Select * from BookAuthor where BookId = ?";
        Connection dbConnection = db.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = dbConnection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String sql1 = "Select * from Author where Id = ?";
                stmt = dbConnection.prepareStatement(sql1);
                stmt.setLong(1, Integer.parseInt(rs.getString("AuthorId")));
                ResultSet ros = stmt.executeQuery();
                while (ros.next()) {
                    authors.add(getAuthor(ros));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return authors;
    }

    private Author getAuthor(ResultSet ros) throws SQLException {
        Author author = new Author();
        author.setId(Integer.parseInt(ros.getString("Id")));
        author.setFirstName(ros.getString("FirstName"));
        author.setLastName(ros.getString("LastName"));
        author.setYear(Integer.parseInt(ros.getString("Year")));
        return author;
    }
}
