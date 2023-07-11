package com.github.mayankpatibandla.testplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SlimeCommand implements CommandExecutor {
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
