package org.example.models.brushes;

import org.example.models.abstractClasses.GeometryShape;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Brush extends GeometryShape {
    private List<Point> points;
    private int brushSize;

    public Brush(int x, int y, int brushSize, Color color) {
        super(x,y,0,color);
        this.points = new ArrayList<>();
        this.brushSize = brushSize;
        this.points.add(new Point(x,y));
    }

    public void addPoint(int x, int y){
        points.add(new Point(x,y));
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(this.getColor());
        for(Point point : points){
            graphics2D.fillOval(point.x - brushSize / 2, point.y - brushSize / 2, brushSize, brushSize);
        }
    }

    @Override
    public void move(int deltaX, int deltaY) {

    }

    @Override
    public boolean containsPoint(int x, int y) {
        return false;
    }
}
