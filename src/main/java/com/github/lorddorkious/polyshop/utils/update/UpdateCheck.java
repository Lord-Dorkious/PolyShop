package com.github.lorddorkious.polyshop.utils.update;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Consumer;

import static com.github.lorddorkious.polyshop.constants.Misc.RESOURCE_ID;

public class UpdateCheck {
    public static final int ID = RESOURCE_ID;
    private final JavaPlugin plugin;
    private final int resourceId;

    public UpdateCheck(JavaPlugin plugin, int resourceId) {
        this.plugin = plugin;
        this.resourceId = resourceId;
    }

    public void getVersion(final Consumer<String> consumer) {
        Bukkit.getScheduler().runTaskAsynchronously(this.plugin, () -> {
            try (InputStream inputStream = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.resourceId).openStream(); Scanner scanner = new Scanner(inputStream)) {
                if (scanner.hasNext()) {
                    consumer.accept(scanner.next());
                }
            } catch (IOException exception) {
                plugin.getLogger().info("Unable to check for updates: " + exception.getMessage());
            }
        });
    }

    public static String getDownloadUrl() {
        return "https://spigotmc.org/resources/" + ID;
    }
}
