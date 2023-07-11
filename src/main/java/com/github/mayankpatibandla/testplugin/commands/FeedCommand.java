package com.github.mayankpatibandla.testplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            String targetName;
            Player target;

            if (args.length != 0) {
                targetName = args[0];
                target = Bukkit.getServer().getPlayerExact(targetName);
            } else {
                target = player;
                targetName = target.getDisplayName();
            }

            if (target == null) {
                player.sendMessage(ChatColor.RED + "Player with the name " + ChatColor.WHITE + targetName + ChatColor.RED + " was not found");
                return false;
            }

            target.setFoodLevel(20);

            target.sendMessage(ChatColor.YELLOW + player.getDisplayName() + " filled your hunger");
            player.sendMessage(ChatColor.YELLOW + "Filled " + target.getDisplayName() + "'s hunger");

            return true;
        }
        return false;
    }
}
