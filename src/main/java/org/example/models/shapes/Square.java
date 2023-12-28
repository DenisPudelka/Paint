package org.example.models.shapes;

import org.example.models.helpClasses.GeometryShape;

import java.awt.*;
import java.io.Serializable;

public class Square extends GeometryShape implements Serializable {

    public Square(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(getColor());
        graphics2D.fillRect(getX() - getRadius(), getY() - getRadius(), 2 * getRadius(), 2 * getRadius());
    }

    @Override
    public void move(int deltaX, int deltaY) {
        setX(getX() + deltaX);
        setY(getY() + deltaY);
    }

    @Override
    public boolean containsPoint(int x, int y) {
        Rectangle square = new Rectangle(getX() - getRadius(), getY() - getRadius(), 2 * getRadius(), 2 * getRadius());
        return square.contains(x, y);
    }
}
