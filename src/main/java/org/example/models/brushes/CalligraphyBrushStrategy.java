package org.example.models.brushes;

import org.example.models.helpClasses.StrokeFactory;

import java.awt.*;
import java.awt.geom.Path2D;

public class CalligraphyBrushStrategy implements BrushStrategy{
    private int brushSize;
    private Color color;

    public CalligraphyBrushStrategy(int brushSize, Color color) {
        this.brushSize = brushSize;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D graphics2D, Path2D path2D) {
        graphics2D.setColor(color);
        BasicStroke stroke = StrokeFactory.getStroke(brushSize, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND);
        graphics2D.setStroke(stroke);
        graphics2D.draw(path2D);
    }
}
