package com.github.lorddorkious.polyshop.utils.storage.sql;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;

abstract class Flatfile implements Connect{
    protected static final DecimalFormat FILE_SIZE_FORMAT = new DecimalFormat("#.##");
    private  Unclosable connect;
    private final Path file;
    protected abstract Connection createConnect(Path file) throws SQLException;

    Flatfile(Path file){
        this.file = file;
    }

    @Override
    public synchronized Connection getConnect() throws SQLException {
        Unclosable connect = this.connect;
        if (connect == null || connect.isClosed()) {
            connect = new Unclosable(createConnect(this.file));
            this.connect = connect;
        }
        return connect;
    }

    @Override
    public void shutdown() throws Exception {
        if (this.connect != null) {
            this.connect.shutdown();
        }
    }

    protected Path getWriteFile() {
        return this.file;
    }
}
