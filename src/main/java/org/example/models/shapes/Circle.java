package org.example.models.shapes;

import org.example.models.helpClasses.GeometryShape;

import java.awt.*;
import java.io.Serializable;

public class Circle extends GeometryShape implements Serializable {

    public Circle(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(getColor());
        graphics2D.fillOval(getX() - getRadius(), getY() - getRadius(), 2 * getRadius(), 2 * getRadius());
    }


    @Override
    public void move(int deltaX, int deltaY) {
        this.setX(this.getX() + deltaX);
        this.setY(this.getY() + deltaY);
    }

    @Override
    public boolean containsPoint(int x, int y) {
        int dx = getX() - x;
        int dy = getY() - y;
        int distanceSquared = dx*dx + dy*dy;
        return distanceSquared <= getRadius()*getRadius();
    }
}
