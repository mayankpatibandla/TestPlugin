package com.github.mayankpatibandla.testplugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        e.setJoinMessage(ChatColor.GOLD + "[Admin] " + ChatColor.RED + player.getDisplayName() + ChatColor.WHITE + " has joined the server :p");
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();

        e.setQuitMessage(ChatColor.GOLD + "[Admin] " + ChatColor.RED + player.getDisplayName() + ChatColor.WHITE + " has left the server :3");
    }
}
