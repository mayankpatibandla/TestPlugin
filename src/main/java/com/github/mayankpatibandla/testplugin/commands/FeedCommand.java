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
            String playerName;
            if (args.length == 0) {
                playerName = "";
            } else {
                playerName = args[0];
            }

            Player target = Bukkit.getServer().getPlayerExact(playerName);

            if (target == null) {
                player.sendMessage(ChatColor.RED + "Player with the name " + ChatColor.WHITE + playerName + ChatColor.RED + " was not found");
                return false;
            }

            target.setFoodLevel(20);
            target.sendMessage(ChatColor.YELLOW + player.getDisplayName() + " filled " + target.getDisplayName() + "'s hunger");
            if (player.getUniqueId() != target.getUniqueId()) {
                player.sendMessage(ChatColor.YELLOW + player.getDisplayName() + " filled " + target.getDisplayName() + "'s hunger");
            }

            return true;
        }
        return false;
    }
}
