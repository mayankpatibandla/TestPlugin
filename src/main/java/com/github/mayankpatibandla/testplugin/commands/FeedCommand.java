package com.github.mayankpatibandla.testplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.List;

public class FeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        List<Entity> targets;

        if (args.length != 0) { // Target Selector
            targets = Bukkit.selectEntities(sender, args[0]);
        } else if (sender instanceof Player) { // Player sends command with no argument
            targets = List.of((Player) sender);
        } else { // Non-player sends command with no argument
            sender.sendMessage(ChatColor.RED + "A player must be targeted");
            return true;
        }

        // Player not found
        if (targets.size() == 0) {
            sender.sendMessage(ChatColor.RED + "The targeted player(s) could not be found");
        }

        int n = 0;
        for (Entity target : targets) {
            if (target instanceof Player p) {
                p.setFoodLevel(20);
                n++;

                p.sendMessage(ChatColor.YELLOW + "Your hunger was filled" + (sender instanceof Player ? " by " + ((Player) sender).getDisplayName() : ""));
            }
        }

        if (n == 0) {
            sender.sendMessage(ChatColor.RED + "No players were found within the selection");
        } else {
            sender.sendMessage(ChatColor.GREEN + "Successfully filled the hunger of " + n + " player(s)");
        }
        return true;
    }
}
