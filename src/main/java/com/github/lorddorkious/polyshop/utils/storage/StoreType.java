package com.github.lorddorkious.polyshop.utils.storage;

import com.google.common.collect.ImmutableList;

import java.util.List;

public enum StoreType {
    // Config file based
    YAML("YAML", "yaml", "yml"),
    HOCON("HOCON", "hocon"),
    TOML("TOML", "toml"),

    // Remote databases
    MONGODB("MongoDB", "mongodb"),
    MARIADB("MariaDB", "mariadb"),
    MYSQL("MySQL", "mysql"),
    POSTGRESQL("PostgreSQL", "postgresql"),

    // Local databases
    SQLITE("SQLite", "sqlite"),
    H2("H2", "h2");

    private final String name;
    private final List<String> ident;

    StoreType(String name,String... ident){
        this.name = name;
        this.ident = ImmutableList.copyOf(ident);
    }

    public static StoreType parse(String name, StoreType def) {
        for (StoreType t : values()) {
            for (String id : t.getIdent()) {
                if (id.equalsIgnoreCase(name)) {
                    return t;
                }
            }
        }
        return def;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getIdent() {
        return this.ident;
    }
}

