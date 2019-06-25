package dao.connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnector {

    //private static final String H2_DRIVER = "org.h2.Driver";
    private static final String H2_URL = "jdbc:h2:~/test2";
    private static final String H2_LOGIN = "username";
    private static final String H2_PASSWORD = "";

    private Connection getConnection() {
        Connection dbConnection = null;

        try {
            dbConnection = DriverManager.getConnection(H2_URL, H2_LOGIN, H2_PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

    public void update (PreparedStmtSetter setter) {
        Connection connection = getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = connection.prepareStatement(setter.getSql());
            setter.setParams(stmt);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public <T>List<T> select(Selector<T> selector) {
        List<T> items = new ArrayList<>();
        Connection dbConnection = getConnection();
        Statement statement = null;
        try {
            statement = dbConnection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = statement.executeQuery(selector.getSql());
            while (rs.next()){
                items.add(selector.convert(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }



}
