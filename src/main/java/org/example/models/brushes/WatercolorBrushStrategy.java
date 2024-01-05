package org.example.models.brushes;

import org.example.models.helpClasses.StrokeFactory;

import java.awt.*;
import java.awt.geom.Path2D;

public class WatercolorBrushStrategy implements BrushStrategy{
    private int brushSize;
    private Color color;

    public WatercolorBrushStrategy(int brushSize, Color color) {
        this.brushSize = brushSize;
        this.color = new Color(color.getRed(), color.getGreen(), color.getBlue(), 80);
    }


    @Override
    public void draw(Graphics2D graphics2D, Path2D path2D) {
        graphics2D.setColor(color);
        BasicStroke stroke = StrokeFactory.getStroke(brushSize, BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL );
        graphics2D.setStroke(stroke);
        graphics2D.draw(path2D);
    }
}
