package com.github.mayankpatibandla.testplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Test Plugin has started!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Test Plugin has stopped!");
    }
}
