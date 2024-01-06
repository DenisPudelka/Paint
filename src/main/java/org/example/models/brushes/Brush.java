package org.example.models.brushes;

import org.example.models.helpClasses.GeometryShape;

import java.awt.*;
import java.awt.geom.Path2D;

public class Brush extends GeometryShape{
    private Path2D path2D;
    private BrushStrategy brushStrategy;

    public Brush(int x, int y, BrushStrategy brushStrategy) {
        this.brushStrategy = brushStrategy;
        this.path2D = new Path2D.Float();
        this.path2D.moveTo(x,y);
    }

    public void addPoint(int x, int y){
        this.path2D.lineTo(x,y);
    }

    public void draw(Graphics2D graphics2D) {
        brushStrategy.draw(graphics2D, path2D);
    }

    @Override
    public void move(int deltaX, int deltaY) {

    }

    @Override
    public boolean containsPoint(int x, int y) {
        return false;
    }
}
