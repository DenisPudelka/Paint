package org.example.models.shapes;

import org.example.models.abstractClasses.GeometryShape;

import java.awt.*;
import java.io.Serializable;

public class House extends GeometryShape implements Serializable {
    public House(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        int size = getRadius() * 2;
        int halfSize = size / 2;

        int houseStartX = getX() - halfSize;
        int houseStartY = getY() - halfSize;

        graphics2D.setColor(getColor());
        graphics2D.fillRect(houseStartX, houseStartY + halfSize, size, halfSize);

        Polygon roof = new Polygon(
                new int[] { houseStartX, getX(), houseStartX + size },
                new int[] { houseStartY + halfSize, houseStartY, houseStartY + halfSize },
                3
        );
        graphics2D.fillPolygon(roof);
    }

    @Override
    public void move(int deltaX, int deltaY) {
        setX(getX() + deltaX);
        setY(getY() + deltaY);
    }

    @Override
    public boolean containsPoint(int x, int y) {
        int size = getRadius() * 2;
        int halfSize = size / 2;

        int houseStartX = getX() - halfSize;
        int houseStartY = getY() - halfSize;

        Rectangle body = new Rectangle(houseStartX, houseStartY + halfSize, size, halfSize);

        Polygon roof = new Polygon(
                new int[] { houseStartX, getX(), houseStartX + size },
                new int[] { houseStartY + halfSize, houseStartY, houseStartY + halfSize },
                3
        );

        return body.contains(x, y) || roof.contains(x, y);
    }
}
