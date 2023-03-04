package com.github.lorddorkious.polyshop;

import com.github.lorddorkious.polyshop.update.UpdateCheck;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.PluginLoadOrder;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.command.Command;
import org.bukkit.plugin.java.annotation.dependency.Dependency;
import org.bukkit.plugin.java.annotation.dependency.SoftDependency;
import org.bukkit.plugin.java.annotation.permission.Permission;
import org.bukkit.plugin.java.annotation.plugin.*;
import org.bukkit.plugin.java.annotation.plugin.author.Author;

import static com.github.lorddorkious.polyshop.constants.Errors.*;
import static com.github.lorddorkious.polyshop.constants.Misc.*;
import static com.github.lorddorkious.polyshop.constants.Perms.*;

@Plugin(name = "PolyShop", version = "0.1.0")
@Description(value = "A shop plugin that allows buying and selling in multiple currencies")
@ApiVersion(value = ApiVersion.Target.v1_19)
@Author("Lord Dorkious")
@Website(value = "https://github.com/LordDorkious/PolyShop")
@LogPrefix(value = POLYSHOP_PREFIX)
@Dependency(value = "Treasury")
@SoftDependency(value = "PlaceholderAPI")
@LoadOrder(value = PluginLoadOrder.STARTUP)
@Permission(name = P_COMMAND_PSHOP, desc = "Ability to run `/polyshop`.", defaultValue = PermissionDefault.TRUE)
@Command(name = "polyshop", desc = "Opens the shop GUI", aliases = {"ps","pShop"}, permission = P_COMMAND_PSHOP, permissionMessage = FUN_ERR, usage = "/<command> [create|delete] <shop name>")

public class Main extends JavaPlugin {
    public static ConsoleCommandSender console;
    public static boolean updateAvail = false;
    public static String webVersion = "";
    public static String yourVersion = "";

    @Override
    public void onEnable() {
        console = this.getServer().getConsoleSender();
        console.sendMessage(POLYSHOP_PREFIX + " Is Enabled");
    }

    private void Init(){
        CheckVer();
    }

    private int ConvertVersionStringToNumber(String string)
    {
        String[] temp = string.replace("-snapshot","").replace("-release","").split("\\.");
        if(temp.length != 3)
            return 1;

        try
        {
            int ret = Integer.parseInt(temp[0]) * 10000;
            ret += Integer.parseInt(temp[1]) * 100;
            ret += Integer.parseInt(temp[2]);

            return ret;
        }
        catch (Exception e)
        {
            return 1;
        }
    }

    private void CheckVer(){
        new UpdateCheck(this, UpdateCheck.ID).getVersion(version -> {
            try{
                webVersion = version;
                yourVersion = getDescription().getVersion();
                int you = ConvertVersionStringToNumber(yourVersion);
                int web = ConvertVersionStringToNumber(webVersion);

                if (web <= you){
                    updateAvail = false;
                    console.sendMessage(POLYSHOP_PREFIX + " Plugin has no updates");
                } else {
                    updateAvail = true;
                    console.sendMessage(POLYSHOP_PREFIX + " Your plugin version is outdated");
                    console.sendMessage(POLYSHOP_PREFIX + UpdateCheck.getDownloadUrl());
                }
            } catch (Exception e) {
                console.sendMessage(POLYSHOP_PREFIX + " Couldn't check for updates. Are you connected to the internet?");
            }
        });
    }

    @Override
    public void onDisable() {
        this.getLogger().info(ChatColor.RED + "Disabled " + this.getName());
    }
}
