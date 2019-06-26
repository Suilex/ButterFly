package dao.impl.selector;

import dao.connect.Selector;
import entity.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetBookIdByBookName implements Selector<Book> {

    private String bookName;

    public GetBookIdByBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String getSql() {
        return "Select Id from Book where Name = ?";
    }



    @Override
    public Book convert(ResultSet rs) {
        Book book = new Book();
        try {
            book.setId(rs.getLong("Id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public void setParams(PreparedStatement statement) {
        try {
            statement.setString(1, bookName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
