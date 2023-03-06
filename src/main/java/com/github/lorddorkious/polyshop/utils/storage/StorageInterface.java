package com.github.lorddorkious.polyshop.utils.storage;

import com.github.lorddorkious.polyshop.Main;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.awt.*;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

public interface StorageInterface {
    Main getPlugin();

    String getImplementName();

    void init() throws Exception;

    void shutdown();

    void deletePlayerData(UUID uniqueId) throws Exception;
    @Nullable UUID getPlayerUniqueId(String username) throws Exception;
    @Nullable String getPlayerName(UUID uniqueId) throws Exception;

    default Map<Component,Component> getMeta(){
        return Collections.emptyMap();
    }
}
