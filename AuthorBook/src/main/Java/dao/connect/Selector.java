package dao.connect;

import java.sql.ResultSet;

public interface Selector<T> {
    String getSql();

    T convert(ResultSet rs);
}
