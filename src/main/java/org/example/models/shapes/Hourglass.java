package org.example.models.shapes;

import org.example.models.abstractClasses.GeometryShape;

import java.awt.*;
import java.io.Serializable;

public class Hourglass extends GeometryShape implements Serializable {
    public Hourglass(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(getColor());
        int[] xPoints = {getX() - getRadius(), getX(), getX() - getRadius(), getX()};
        int[] yPoints = {getY(), getY(), getY() + getRadius(), getY() + getRadius()};
        graphics2D.fillPolygon(xPoints,yPoints,4);
    }

    @Override
    public void move(int deltaX, int deltaY) {
        setX(getX() + deltaX);
        setY(getY() + deltaY);
    }

    @Override
    public boolean containsPoint(int x, int y) {
        int[] xPoints = {getX() - getRadius(), getX(), getX() - getRadius(), getX()};
        int[] yPoints = {getY(), getY(), getY() + getRadius(), getY() + getRadius()};
        Polygon polygon = new Polygon(xPoints, yPoints, 4);
        return polygon.contains(x, y);
    }
}
