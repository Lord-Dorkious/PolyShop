package com.github.lorddorkious.polyshop.utils;

import com.github.lorddorkious.polyshop.Main;
import com.github.lorddorkious.polyshop.utils.storage.StorageInterface;

public class StorageUtil {
    private final Main plugin;
    private final StorageInterface implement;

    public StorageUtil(Main plugin, StorageInterface implement) {
        this.plugin = plugin;
        this.implement = implement;
    }

    public StorageInterface getImplement(){
        return this.implement;
    }
}
