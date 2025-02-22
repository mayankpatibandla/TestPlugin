package com.github.mayankpatibandla.testplugin;

import com.github.mayankpatibandla.testplugin.commands.FeedCommand;
import com.github.mayankpatibandla.testplugin.commands.GodCommand;
import com.github.mayankpatibandla.testplugin.commands.SetSpawnCommand;
import com.github.mayankpatibandla.testplugin.commands.SlimeCommand;
import com.github.mayankpatibandla.testplugin.listeners.JoinLeaveListener;
import com.github.mayankpatibandla.testplugin.listeners.ShearSheepListener;
import com.github.mayankpatibandla.testplugin.listeners.XPBottleBreakListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugin extends JavaPlugin {
    private static TestPlugin plugin;

    public static TestPlugin getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        // config.yml
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // Start message
        System.out.println(getConfig().getString("StartMessage"));

        // Commands
        getCommand("slime").setExecutor(new SlimeCommand());
        getCommand("god").setExecutor(new GodCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("setspawn").setExecutor(new SetSpawnCommand());

        // Event listeners
        getServer().getPluginManager().registerEvents(new XPBottleBreakListener(), this);
        getServer().getPluginManager().registerEvents(new ShearSheepListener(), this);
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);
        //        getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        // Stop message
        System.out.println(getConfig().getString("StopMessage"));
    }
}
