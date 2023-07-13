package com.github.mayankpatibandla.testplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FeedCommand implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        List<Entity> targets;

        if (args.length != 0) { // Target Selector
            targets = Bukkit.selectEntities(sender, args[0]);
        } else if (sender instanceof Player p) { // Player sends command with no argument
            targets = List.of(p);
        } else { // Non-player sends command with no argument
            sender.sendMessage(ChatColor.RED + "A player must be targeted");
            return true;
        }

        // Player not found
        if (targets.size() == 0) {
            sender.sendMessage(ChatColor.RED + "The targeted player(s) could not be found");
            return true;
        }

        int n = 0;
        for (Entity target : targets) {
            if (target instanceof Player p) {
                p.setFoodLevel(20);
                p.setSaturation(20);

                n++;

                p.sendMessage(ChatColor.YELLOW + "Your hunger was filled" + (sender instanceof Player pSender ? " by " + pSender.getDisplayName() : ""));
            }
        }

        if (n == 0) {
            sender.sendMessage(ChatColor.RED + "No players were found within the selection");
        } else {
            sender.sendMessage(ChatColor.GREEN + "Successfully filled the hunger of " + n + " player(s)");
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            List<String> names = new ArrayList<>();
            for (Player p : Bukkit.getOnlinePlayers()) {
                names.add(p.getName());
            }
            return names;
        } else if (args.length == 2) {
            List<String> arguments = new ArrayList<>();
            arguments.add("test1");
            arguments.add("test2");
            return arguments;
        }
        return Collections.emptyList();
    }
}
