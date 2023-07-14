package com.github.mayankpatibandla.testplugin.util;

import org.bukkit.Location;

import java.text.DecimalFormat;

public class Coordinate {
    public static final DecimalFormat format = new DecimalFormat("#.##");

    public static Location parseLocation(String[] arg, Location original) {
        double[] base = {original.getX(), original.getY(), original.getZ()};
        double[] result = new double[3];

        for (int i = 0; i < 3; i++) {
            if (arg[i].startsWith("~")) { // Relative coordinate
                if (arg[i].length() > 1) {
                    result[i] = Double.parseDouble(arg[i].substring(1)) + base[i];
                } else {
                    result[i] = base[i];
                }
            } else if (arg[i].startsWith("^")) { // TODO: Local coordinate
                System.out.println("Local coordinate WIP");
                result[i] = Double.parseDouble(arg[i]);
            } else { // World Coordinate
                result[i] = Double.parseDouble(arg[i]);
            }
        }

        return new Location(original.getWorld(), result[0], result[1], result[2]);
    }
}
