package dao.connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface Selector<T> {
    String getSql();

    T convert(ResultSet rs);

    void setParams(PreparedStatement statement);
}
