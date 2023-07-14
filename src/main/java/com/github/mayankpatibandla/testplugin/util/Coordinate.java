package com.github.mayankpatibandla.testplugin.util;

public class Coordinate {
    public static double parseCoordinate(String arg, double base) {
        if (arg.startsWith("~")) { // Relative coordinate
            if (arg.length() > 1) {
                return Double.parseDouble(arg.substring(1)) + base;
            } else {
                return base;
            }
        } else if (arg.startsWith("^")) { // TODO: Local coordinate
            System.out.println("Local coordinate WIP");
            return Double.parseDouble(arg);
        } else {
            return Double.parseDouble(arg);
        }
    }
}
