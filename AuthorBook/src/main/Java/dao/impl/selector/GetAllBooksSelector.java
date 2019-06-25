package dao.impl.selector;

import dao.connect.Selector;
import entity.Book;

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
            book.setId(Integer.parseInt(rs.getString("Id")));
            book.setName(rs.getString("Name"));
            book.setPublished(rs.getString("Published"));
            book.setYear(Integer.parseInt(rs.getString("Year")));
            book.setDescription(rs.getString("Description"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }
}
