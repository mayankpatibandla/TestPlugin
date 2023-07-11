package com.github.mayankpatibandla.testplugin;

import com.github.mayankpatibandla.testplugin.commands.GodCommand;
import com.github.mayankpatibandla.testplugin.commands.SlimeCommand;
import com.github.mayankpatibandla.testplugin.listeners.JoinLeaveListener;
import com.github.mayankpatibandla.testplugin.listeners.ShearSheepListener;
import com.github.mayankpatibandla.testplugin.listeners.XPBottleBreakListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Test Plugin has started!");

        getCommand("slime").setExecutor(new SlimeCommand());
        getCommand("god").setExecutor(new GodCommand());

        getServer().getPluginManager().registerEvents(new XPBottleBreakListener(), this);
        getServer().getPluginManager().registerEvents(new ShearSheepListener(), this);
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);
//        getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Test Plugin has stopped!");
    }
}
