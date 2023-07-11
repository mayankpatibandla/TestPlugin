package com.github.mayankpatibandla.testplugin;

import com.github.mayankpatibandla.testplugin.listeners.JoinLeaveListener;
import com.github.mayankpatibandla.testplugin.listeners.ShearSheepListener;
import com.github.mayankpatibandla.testplugin.listeners.XPBottleBreakListener;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Test Plugin has started!");

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

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // /slime - summons a slime at the sender's location
        if (command.getName().equalsIgnoreCase("slime")) {
            Bukkit.getServer().dispatchCommand(sender, "summon minecraft:slime ~ ~ ~ {Size:16}");
            if (sender instanceof Player player) {
                player.sendMessage("Summoned a slime!");
            }
        }

        return true;
    }
}
