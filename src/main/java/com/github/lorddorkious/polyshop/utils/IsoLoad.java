package com.github.lorddorkious.polyshop.utils;

import java.net.URL;
import java.net.URLClassLoader;

public class IsoLoad extends URLClassLoader {
    static {
        ClassLoader.registerAsParallelCapable();
    }

    public IsoLoad(URL[] urls){
        super(urls,ClassLoader.getSystemClassLoader().getParent());
    }
}
