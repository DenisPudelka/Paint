package org.example.models.brushes;

import org.example.models.helpClasses.GeometryShape;

import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

public class Brush extends GeometryShape {
    private Path2D path2D;
    private int brushSize;

    public Brush(int x, int y, int brushSize, Color color) {
        super(x,y,0, color);
        this.brushSize = brushSize;
        this.path2D = new Path2D.Float();
        this.path2D.moveTo(x,y);
    }

    public void addPoint(int x, int y){
        this.path2D.lineTo(x,y);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(getColor());
        graphics2D.setStroke(new BasicStroke(brushSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
        graphics2D.draw(path2D);
    }

    @Override
    public void move(int deltaX, int deltaY) {

    }

    @Override
    public boolean containsPoint(int x, int y) {
        return false;
    }
}
