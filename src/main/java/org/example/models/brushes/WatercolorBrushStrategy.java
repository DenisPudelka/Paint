package org.example.models.brushes;

import java.awt.*;
import java.awt.geom.Path2D;

public class WatercolorBrushStrategy implements BrushStrategy{
    private int brushSize;
    private Color color;

    public WatercolorBrushStrategy(int brushSize, Color color) {
        this.brushSize = brushSize;
        this.color = new Color(color.getRed(), color.getGreen(), color.getBlue(), 128);
    }


    @Override
    public void draw(Graphics2D graphics2D, Path2D path2D) {
        graphics2D.setColor(color);
        graphics2D.setStroke(new BasicStroke(brushSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
        graphics2D.draw(path2D);
    }
}
