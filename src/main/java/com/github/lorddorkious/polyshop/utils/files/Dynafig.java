package com.github.lorddorkious.polyshop.utils.files;

import com.github.lorddorkious.polyshop.Main;
import com.github.lorddorkious.polyshop.constants.Misc;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Dynafig {
    private File file;
    protected FileConfiguration custFile;

    public void setup(String name, String folder)
    {
        String path = name + ".yml";
        if (folder != null)
        {
            path = folder + "/" + path;

            File directory = new File(Main.plugin.getDataFolder() + "/" + folder);
            if (!directory.exists())
            {
                directory.mkdir();
            }
        }

        file = new File(Main.plugin.getDataFolder(), path);

        if (!file.exists())
        {
            try
            {
                file.createNewFile();
            } catch (IOException e)
            {
                Main.console.sendMessage("Fatal error! Config Setup Fail. File name: " + name);
            }
        }

        custFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration GetFileFromPath(String name, String folder)
    {
        File tempFile = new File(Bukkit.getServer().getPluginManager().getPlugin("DynamicShop").getDataFolder(), folder + "/" + name + ".yml");

        if (!tempFile.exists())
        {
            Main.console.sendMessage(Misc.POLYSHOP_PREFIX + name + " not found");
            return null;
        }

        return YamlConfiguration.loadConfiguration(tempFile);
    }

    public void rename(String newName)
    {
        if (!file.exists())
            return;

        try
        {
            File newFile = new File(file.toPath().resolveSibling(newName) + ".yml");
            Files.copy(file.toPath(), newFile.toPath());
            file.delete();
            file = newFile;
        }
        catch (Exception e)
        {
            System.out.println("Couldn't rename: " + e);
        }
    }

    public boolean open(String name, String folder)
    {
        file = new File(Main.plugin.getDataFolder(), folder + "/" + name + ".yml");

        if (!file.exists())
        {
            Main.console.sendMessage(Misc.POLYSHOP_PREFIX + name + " not found");
            return false;
        }

        custFile = YamlConfiguration.loadConfiguration(file);
        return true;
    }

    public void copy(String newName)
    {
        if (!file.exists())
            return;

        try
        {
            File newFile = new File(file.toPath().resolveSibling(newName) + ".yml");
            Files.copy(file.toPath(), newFile.toPath());
        }
        catch (Exception e)
        {
            System.out.println("Couldn't copy: " + e);
        }
    }

    public void save()
    {
        try
        {
            custFile.save(file);
        } catch (IOException e)
        {
            Main.console.sendMessage("Couldn't save file :" + e);
        }
    }

    public void delete(){
        if(file.exists()){
            if(!file.delete()){
                System.out.println("Couldn't delete file: "+file.getName());
            }
        } else{
            System.out.println("Couldn't delete file. Does it exist?");
        }
    }

    public void reload(){
        custFile = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration get()
    {
        return custFile;
    }
}
