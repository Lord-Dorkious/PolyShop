package com.github.lorddorkious.polyshop.utils.storage;

import com.github.lorddorkious.polyshop.Main;

import java.awt.*;
import java.util.Collections;
import java.util.Map;

public interface StorageInterface {
    Main getPlugin();

    String getImplementName();

    void init() throws Exception;

    void shutdown();

    default Map<Component,Component> getMeta(){
        return Collections.emptyMap();
    }
}
