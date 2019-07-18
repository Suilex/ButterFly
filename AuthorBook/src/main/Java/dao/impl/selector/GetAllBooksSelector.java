package dao.impl.selector;

import dao.connect.Selector;
import entity.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAllBooksSelector implements Selector<Book> {

    @Override
    public String getSql() {
        return "Select * from Book";
    }

    @Override
    public Book convert(ResultSet rs) {
        Book book = new Book();
        try {
            book.setId(rs.getLong("Id"));
            book.setName(rs.getString("Name"));
            book.setPublished(rs.getString("Published"));
            book.setYear(rs.getLong("Year"));
            book.setDescription(rs.getString("Description"));
            book.setAuthorId(rs.getLong("AuthorId"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public void setParams(PreparedStatement statement) {
    }
}
