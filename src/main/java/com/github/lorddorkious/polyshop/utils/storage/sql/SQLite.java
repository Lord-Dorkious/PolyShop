package com.github.lorddorkious.polyshop.utils.storage.sql;

import com.github.lorddorkious.polyshop.Main;

import java.lang.reflect.Constructor;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.function.Function;

public class SQLite extends Flatfile{
    private Constructor<?> connectConst;

    @Override
    protected Connection createConnect(Path file) throws SQLException {
        try {
            return (Connection) this.connectConst.newInstance("jdbc:sqlite:" + file.toString(), file.toString(), new Properties());
        } catch (ReflectiveOperationException e) {
            if (e.getCause() instanceof SQLException) {
                throw (SQLException) e.getCause();
            }
            throw new RuntimeException(e);
        }
    }

    public SQLite(Path file){
        super(file);
    }

    @Override
    public String getImplementName() {
        return "SQLite";
    }

    @Override
    public void init(Main plugin) {

    }

    @Override
    public Function<String, String> getStatementProc() {
        return s -> s.replace('\'', '`');
    }
}
