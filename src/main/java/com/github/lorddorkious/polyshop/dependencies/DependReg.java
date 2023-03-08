package com.github.lorddorkious.polyshop.dependencies;

import com.github.lorddorkious.polyshop.utils.storage.StoreType;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.SetMultimap;

public class DependReg {
    private static final SetMultimap<StoreType, Depends> STORAGE_DEPENDENCIES = ImmutableSetMultimap.<StoreType, Depends>builder()
            .putAll(StoreType.YAML,           Depends.CONFIGURATE_CORE, Depends.CONFIGURATE_YAML, Depends.SNAKEYAML)
            .putAll(StoreType.HOCON,          Depends.CONFIGURATE_CORE, Depends.CONFIGURATE_HOCON, Depends.HOCON_CONFIG)
            .putAll(StoreType.TOML,           Depends.CONFIGURATE_CORE, Depends.CONFIGURATE_TOML, Depends.TOML4J)
            .putAll(StoreType.MONGODB,        Depends.MONGODB_DRIVER_CORE, Depends.MONGODB_DRIVER_LEGACY, Depends.MONGODB_DRIVER_SYNC, Depends.MONGODB_DRIVER_BSON)
            .putAll(StoreType.MARIADB,        Depends.SLF4J_API, Depends.SLF4J_SIMPLE, Depends.HIKARI, Depends.MARIADB_DRIVER)
            .putAll(StoreType.MYSQL,          Depends.SLF4J_API, Depends.SLF4J_SIMPLE, Depends.HIKARI, Depends.MYSQL_DRIVER)
            .putAll(StoreType.POSTGRESQL,     Depends.SLF4J_API, Depends.SLF4J_SIMPLE, Depends.HIKARI, Depends.POSTGRESQL_DRIVER)
            .putAll(StoreType.SQLITE,         Depends.SQLITE_DRIVER)
            .putAll(StoreType.H2,             Depends.H2_DRIVER)
            .build();
}
