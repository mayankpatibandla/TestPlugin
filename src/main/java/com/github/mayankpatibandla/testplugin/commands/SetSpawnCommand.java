package com.github.mayankpatibandla.testplugin.commands;

import com.github.mayankpatibandla.testplugin.TestPlugin;
import com.github.mayankpatibandla.testplugin.util.Coordinate;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SetSpawnCommand implements TabExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p) {
            Location location = Coordinate.parseLocation(args, p.getLocation());
            TestPlugin.getPlugin().getConfig().set("spawn", location);
            TestPlugin.getPlugin().saveConfig();

            sender.sendMessage(ChatColor.GREEN +
                               String.format("Spawn successfully set to X: %f Y: %f, Z: %f", location.getX(),
                                             location.getY(), location.getZ()));
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p) {
            Location location = p.getLocation();
            String[] locationStrings =
                    {Coordinate.format.format(location.getX()), Coordinate.format.format(location.getY()),
                     Coordinate.format.format(location.getZ())};

            List<String> arguments = new ArrayList<>();

            if (args.length == 1) {
                arguments.add(locationStrings[0]);
                arguments.add(locationStrings[0] + " " + locationStrings[1]);
                arguments.add(locationStrings[0] + " " + locationStrings[1] + " " + locationStrings[2]);
            } else if (args.length == 2) {
                arguments.add(locationStrings[1]);
                arguments.add(locationStrings[1] + " " + locationStrings[2]);
            } else if (args.length == 3) {
                arguments.add(locationStrings[2]);
            }

            return arguments;
        }
        return Collections.emptyList();
    }
}
