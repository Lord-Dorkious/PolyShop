package com.github.lorddorkious.polyshop.utils.storage.sql;

import com.github.lorddorkious.polyshop.Main;

import java.lang.reflect.Constructor;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.function.Function;

public class H2 extends Flatfile{
    private Constructor<?> connectConst;

    public H2(Path file){
        super(file);

    }

    @Override
    public String getImplementName() {
        return "H2";
    }

    @Override
    public void init(Main plugin) {

    }

    @Override
    public void shutdown() throws Exception {

    }

    @Override
    public Function<String, String> getStatementProc() {
        return null;
    }

    @Override
    public Connection getConnect() throws SQLException {
        return null;
    }

    @Override
    protected Connection createConnect(Path file) throws SQLException {
        try {
            return (Connection) this.connectConst.newInstance("jdbc:h2:" + file.toString(), new Properties(), null, null, false);
        } catch (ReflectiveOperationException e) {
            if (e.getCause() instanceof SQLException) {
                throw (SQLException) e.getCause();
            }
            throw new RuntimeException(e);
        }
    }
}
