package org.example.models.brushes;

import java.awt.*;
import java.awt.geom.Path2D;

public class PencilBrushStrategy implements BrushStrategy{
    private int brushSize;
    private Color color;

    public PencilBrushStrategy(int brushSize, Color color) {
        this.brushSize = Math.max(1, brushSize/4);
        this.color = color;
    }

    @Override
    public void draw(Graphics2D graphics2D, Path2D path2D) {
        graphics2D.setColor(color);
        graphics2D.setStroke(new BasicStroke(brushSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
        graphics2D.draw(path2D);
    }
}
