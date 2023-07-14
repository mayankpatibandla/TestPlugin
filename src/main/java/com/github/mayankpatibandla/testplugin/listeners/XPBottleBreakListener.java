package com.github.mayankpatibandla.testplugin.listeners;

import org.bukkit.block.Block;
import org.bukkit.entity.ThrownExpBottle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExpBottleEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

public class XPBottleBreakListener implements Listener {

    @EventHandler
    public void onXPBottleBreak(ExpBottleEvent e) {
        e.setExperience(0);
        e.setShowEffect(false);
    }

    @EventHandler
    public void onHit(ProjectileHitEvent e) {
        if (!(e.getEntity() instanceof ThrownExpBottle)) {
            return;
        }
        Block block = e.getHitBlock();
        if (block == null) {
            return;
        }
        block.breakNaturally();
    }
}
