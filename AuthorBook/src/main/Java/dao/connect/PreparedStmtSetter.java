package dao.connect;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStmtSetter {
    String getSql();

    void setParams(PreparedStatement stmt) throws SQLException;
}