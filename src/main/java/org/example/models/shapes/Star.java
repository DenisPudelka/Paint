package org.example.models.shapes;

import org.example.models.abstractClasses.GeometryShape;

import java.awt.*;
import java.io.Serializable;

public class Star extends GeometryShape implements Serializable {
    public Star(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
    }

    Star() {
        super(0, 0, 0, null);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        int[] xPoints = new int[10];
        int[] yPoints = new int[10];
        double angleStep = 2 * Math.PI / 5;
        double innerRadius = getRadius() * 0.5;

        for (int i = 0; i < 5; i++) {
            xPoints[i * 2] = getX() + (int) (getRadius() * Math.cos(i * angleStep));
            yPoints[i * 2] = getY() + (int) (getRadius() * Math.sin(i * angleStep));
            xPoints[i * 2 + 1] = getX() + (int) (innerRadius * Math.cos(i * angleStep + angleStep / 2));
            yPoints[i * 2 + 1] = getY() + (int) (innerRadius * Math.sin(i * angleStep + angleStep / 2));
        }

        Polygon star = new Polygon(xPoints, yPoints, xPoints.length);
        graphics2D.setColor(getColor());
        graphics2D.fill(star);
    }

    @Override
    public void move(int deltaX, int deltaY) {
        setX(getX() + deltaX);
        setY(getY() + deltaY);
    }

    @Override
    public boolean containsPoint(int x, int y) {
        int[] xPoints = new int[10];
        int[] yPoints = new int[10];
        double angleStep = 2 * Math.PI / 5;
        double innerRadius = getRadius() * 0.5;

        for (int i = 0; i < 5; i++) {
            xPoints[i * 2] = getX() + (int) (getRadius() * Math.cos(i * angleStep));
            yPoints[i * 2] = getY() + (int) (getRadius() * Math.sin(i * angleStep));
            xPoints[i * 2 + 1] = getX() + (int) (innerRadius * Math.cos(i * angleStep + angleStep / 2));
            yPoints[i * 2 + 1] = getY() + (int) (innerRadius * Math.sin(i * angleStep + angleStep / 2));
        }

        Polygon star = new Polygon(xPoints, yPoints, xPoints.length);
        return star.contains(x, y);
    }

}
