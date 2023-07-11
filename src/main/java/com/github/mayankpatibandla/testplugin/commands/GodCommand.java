package com.github.mayankpatibandla.testplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            player.setInvulnerable(!player.isInvulnerable());

            if (player.isInvulnerable()) {
                player.sendMessage(ChatColor.GREEN + "God Mode Enabled!");
            } else {
                player.sendMessage(ChatColor.RED + "God Mode Disabled!");
            }

            return true;
        }
        return false;
    }
}
