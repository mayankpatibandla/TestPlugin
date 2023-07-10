package com.github.mayankpatibandla.testplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ShearSheepListener implements Listener {
    @EventHandler
    public void onShearSheep(PlayerShearEntityEvent e) {
        Player player = e.getPlayer();
        Entity entity = e.getEntity();

        if (entity.getType() != EntityType.SHEEP) {
            player.sendMessage("Not a sheep!");
            return;
        }

        Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = board.registerNewTeam("Sheep");
        team.setColor(ChatColor.LIGHT_PURPLE);
        team.addEntry(entity.getUniqueId().toString());
        entity.setGlowing(true);
    }
}
