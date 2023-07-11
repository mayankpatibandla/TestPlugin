package com.github.mayankpatibandla.testplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            player.setFoodLevel(20);
            player.sendMessage(ChatColor.YELLOW + "Filled " + player.getDisplayName() + "'s hunger");
            return true;
        }
        return false;
    }
}
