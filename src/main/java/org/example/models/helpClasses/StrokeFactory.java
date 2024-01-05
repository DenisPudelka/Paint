package org.example.models.helpClasses;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class StrokeFactory {
    private static final Map<String, BasicStroke> strokes = new HashMap<>();

    public static BasicStroke getStroke(int brushSize, int cap, int join){
        String key = brushSize + ":" + cap + ":" + join;
        return strokes.computeIfAbsent(key, k -> new BasicStroke(brushSize, cap, join));
    }
}
