package com.github.lorddorkious.polyshop.dependencies;

public enum Depends {
    MARIADB_DRIVER(
            "org{}mariadb{}jdbc",
            "mariadb-java-client",
            "2.7.2",
            "o/Z3bfCELPZefxWFFQEtUwfalJ9mBCKC4e5EdN0Z9Eg=",
            Relocation.of("mariadb", "org{}mariadb{}jdbc")
    ),
    MYSQL_DRIVER(
            "mysql",
            "mysql-connector-java",
            "8.0.23",
            "/31bQCr9OcEnh0cVBaM6MEEDsjjsG3pE6JNtMynadTU=",
            Relocation.of("mysql", "com{}mysql")
    ),
    POSTGRESQL_DRIVER(
            "org{}postgresql",
            "postgresql",
            "42.2.19",
            "IydH+gkk2Iom36QrgSi2+hFAgC2AQSWJFZboyl8pEyI=",
            Relocation.of("postgresql", "org{}postgresql")
    ),
    H2_DRIVER(
            "com.h2database",
            "h2",
            "2.1.214",
            "1iPNwPYdIYz1SajQnxw5H/kQlhFrIuJHVHX85PvnK9A="
            // we don't apply relocations to h2 - it gets loaded via
            // an isolated classloader
    ),
    SQLITE_DRIVER(
            "org.xerial",
            "sqlite-jdbc",
            "3.28.0",
            "k3hOVtv1RiXgbJks+D9w6cG93Vxq0dPwEwjIex2WG2A="
            // we don't apply relocations to sqlite - it gets loaded via
            // an isolated classloader
    ),
    HIKARI(
            "com{}zaxxer",
            "HikariCP",
            "4.0.3",
            "fAJK7/HBBjV210RTUT+d5kR9jmJNF/jifzCi6XaIxsk=",
            Relocation.of("hikari", "com{}zaxxer{}hikari")
    ),
    SLF4J_SIMPLE(
            "org.slf4j",
            "slf4j-simple",
            "1.7.30",
            "i5J5y/9rn4hZTvrjzwIDm2mVAw7sAj7UOSh0jEFnD+4="
    ),
    SLF4J_API(
            "org.slf4j",
            "slf4j-api",
            "1.7.30",
            "zboHlk0btAoHYUhcax6ML4/Z6x0ZxTkorA1/lRAQXFc="
    ),
    MONGODB_DRIVER_CORE(
            "org.mongodb",
            "mongodb-driver-core",
            "4.5.0",
            "awqoW0ImUcrCTA2d1rDCjDLEjLMCrOjKWIcC7E+zLGA=",
            Relocation.of("mongodb", "com{}mongodb"),
            Relocation.of("bson", "org{}bson")
    ),
    MONGODB_DRIVER_LEGACY(
            "org.mongodb",
            "mongodb-driver-legacy",
            "4.5.0",
            "77KZGIr3KZmzBpN69rGOLXmnlJIBCXRl/U4gEIdlFhY=",
            Relocation.of("mongodb", "com{}mongodb"),
            Relocation.of("bson", "org{}bson")
    ),
    MONGODB_DRIVER_SYNC(
            "org.mongodb",
            "mongodb-driver-sync",
            "4.5.0",
            "q9XDSGJjlo/Ek6jHoCbqWnaK/dghB8y9aDM0hCLiSvk=",
            Relocation.of("mongodb", "com{}mongodb"),
            Relocation.of("bson", "org{}bson")
    ),
    MONGODB_DRIVER_BSON(
            "org.mongodb",
            "bson",
            "4.5.0",
            "6CFyEzxbdeiBEXdDBmcgqWs5dvicgFkBLU3MlQUIqRA=",
            Relocation.of("mongodb", "com{}mongodb"),
            Relocation.of("bson", "org{}bson")
    ),
    CONFIGURATE_CORE(
            "org{}spongepowered",
            "configurate-core",
            "3.7.2",
            "XF2LzWLkSV0wyQRDt33I+gDlf3t2WzxH1h8JCZZgPp4=",
            Relocation.of("configurate", "ninja{}leaping{}configurate")
    ),
    CONFIGURATE_YAML(
            "org{}spongepowered",
            "configurate-yaml",
            "3.7.2",
            "OBfYn4nSMGZfVf2DoZhZq+G9TF1mODX/C5OOz/mkPmc=",
            Relocation.of("configurate", "ninja{}leaping{}configurate")
    ),
    SNAKEYAML(
            "org.yaml",
            "snakeyaml",
            "1.28",
            "NURqFCFDXUXkxqwN47U3hSfVzCRGwHGD4kRHcwzh//o=",
            Relocation.of("yaml", "org{}yaml{}snakeyaml")
    ),
    CONFIGURATE_HOCON(
            "org{}spongepowered",
            "configurate-hocon",
            "3.7.2",
            "GOORZlK1FKLzdIm7dKyyXtBdvk7Z89HARAd2H6NiWSY=",
            Relocation.of("configurate", "ninja{}leaping{}configurate"),
            Relocation.of("hocon", "com{}typesafe{}config")
    ),
    HOCON_CONFIG(
            "com{}typesafe",
            "config",
            "1.4.1",
            "TAqn4iPHXIhAxB/Bg9TNMRgUCh7lA+PgjOZu0nlMlI8=",
            Relocation.of("hocon", "com{}typesafe{}config")
    ),
    CONFIGURATE_TOML(
            "me{}lucko{}configurate",
            "configurate-toml",
            "3.7",
            "EmyLOfsiR74QGhkktqhexMN8tC3kg1cM1UhM5MCmxuE=",
            Relocation.of("configurate", "ninja{}leaping{}configurate"),
            Relocation.of("toml4j", "com{}moandjiezana{}toml")
    ),
    TOML4J(
            "com{}moandjiezana{}toml",
            "toml4j",
            "0.7.2",
            "9UdeY+fonl22IiNImux6Vr0wNUN3IHehfCy1TBnKOiA=",
            Relocation.of("toml4j", "com{}moandjiezana{}toml")
    );
}
