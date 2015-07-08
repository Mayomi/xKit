package com.mengcraft.xkit.orm;

import java.lang.reflect.Field;

import org.bukkit.plugin.java.JavaPlugin;

import com.avaje.ebean.EbeanServer;

public class ReflectUtil {

    public static final ReflectUtil UTIL = new ReflectUtil();
    
    private Field server;
    private Field loader;
    
    public void register(JavaPlugin proxy, EbeanServer in) 
            throws Exception {
        if (server == null) {
            server = JavaPlugin.class.getDeclaredField("ebean");
            server.setAccessible(true);
        }
        server.set(proxy, in);
    }
    
    public ClassLoader loader(JavaPlugin in) throws Exception {
        if (loader == null) {
            loader = JavaPlugin.class.getDeclaredField("classLoader");
            loader.setAccessible(true);
        }
        return (ClassLoader) loader.get(in);
    }
    
}
