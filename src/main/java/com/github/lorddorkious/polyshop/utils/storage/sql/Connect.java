package com.github.lorddorkious.polyshop.utils.storage.sql;

import com.github.lorddorkious.polyshop.Main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.function.Function;

public interface Connect {
    String getImplementName();
    void init(Main plugin);
    void shutdown() throws Exception;
    Function<String,String> getStatementProc();
    Connection getConnect() throws SQLException;
}
