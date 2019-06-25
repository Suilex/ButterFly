package dao.impl;

import dao.connect.DBConnector;
import dao.BookAuthorDao;
import dao.impl.setter.BookAuthorDeleteAuthorSetter;
import dao.impl.setter.BookAuthorDeleteBookSetter;
import dao.impl.setter.BookAuthorInsertSetter;
import entity.BookAuthor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookAuthorDaoImpl implements BookAuthorDao {

    private DBConnector db;

    public BookAuthorDaoImpl(DBConnector db) {
        this.db = db;
    }

    public void add(BookAuthor bookAuthor) {
        db.update(new BookAuthorInsertSetter(bookAuthor));
    }

    public void deleteAuthor(BookAuthor bookAuthor) {
        db.update(new BookAuthorDeleteAuthorSetter(bookAuthor));
    }

    public void deleteBook(BookAuthor bookAuthor) {
        db.update(new BookAuthorDeleteBookSetter(bookAuthor));
    }

    @Override
    public List<BookAuthor> getAll() {
        List<BookAuthor> bookAuthors = new ArrayList<>();
        Connection dbConnection = db.getConnection();
        Statement statement = null;
        try {
            statement = dbConnection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = statement.executeQuery("Select * from BookAuthor");
            while (rs.next()){
                BookAuthor bookAuthor = new BookAuthor();
                bookAuthor.setAuthorId(Integer.parseInt(rs.getString("AuthorId")));
                bookAuthor.setBookId(Integer.parseInt(rs.getString("BookId")));
                bookAuthors.add(bookAuthor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookAuthors;
    }

    public List<BookAuthor> getAllByParamNameAndValue(int value, String name) {
        List<BookAuthor> bookAuthors = new ArrayList<>();
        String sql = "Select * from BookAuthor where " + name + " = ?";
        Connection dbConnection = db.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = dbConnection.prepareStatement(sql);
            stmt.setLong(1, value);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                BookAuthor bookAuthor = new BookAuthor();
                bookAuthor.setAuthorId(Integer.parseInt(rs.getString("AuthorId")));
                bookAuthor.setBookId(Integer.parseInt(rs.getString("BookId")));
                bookAuthors.add(bookAuthor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookAuthors;
    }
}