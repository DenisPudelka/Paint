package org.example.models.helpClasses;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ColorFactory {

    private static final Map<Color, Color> colors = new HashMap<>();

    public static Color getColor(int r, int g, int b){
        Color color = new Color(r,g,b);
        System.out.println(colors.size());
        return colors.computeIfAbsent(color, key -> color);
    }
}
