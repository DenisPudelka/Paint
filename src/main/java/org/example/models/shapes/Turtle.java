package org.example.models.shapes;

import org.example.models.abstractClasses.GeometryShape;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;

public class Turtle extends GeometryShape implements Serializable {

    private Color shellColor;
    private Color headColor;
    private int headRadius;
    private int shellRadius;

    public Turtle(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
        this.shellRadius = calculateShellRadius(radius);
        this.headRadius = calculateHeadRadius(radius);
        this.headColor = Color.PINK;
        this.shellColor = Color.green;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(shellColor);
        graphics2D.fillOval(getX(), getY(), shellRadius * 2, shellRadius * 2);

        graphics2D.setColor(headColor);
        int headX = getX() + shellRadius - (headRadius / 2);
        int headY = getY() - headRadius;
        graphics2D.fillOval(headX, headY, headRadius * 2, headRadius * 2);
    }

    @Override
    public void move(int deltaX, int deltaY) {
        setX(getX() + deltaX);
        setY(getY() + deltaY);
    }

    @Override
    public boolean containsPoint(int x, int y) {
        if (new Ellipse2D.Float(getX(), getY(), shellRadius * 2, shellRadius * 2).contains(x, y)) {
            return true;
        }

        int headX = getX() + shellRadius - (headRadius / 2);
        int headY = getY() - headRadius;
        if (new Ellipse2D.Float(headX, headY, headRadius * 2, headRadius * 2).contains(x, y)) {
            return true;
        }

        return false;
    }


    private int calculateShellRadius(int radius) {
        return (int) (radius * 0.75);
    }

    private int calculateHeadRadius(int radius) {
        return (int) (radius * 0.25);
    }
}
