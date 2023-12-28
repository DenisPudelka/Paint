package org.example.models.shapes;

import org.example.models.helpClasses.GeometryShape;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

public class Tree extends GeometryShape implements Serializable {
    public Tree(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        int diameter = getRadius() * 2;
        int height = (int)(diameter * 1.5);

        graphics2D.setColor(getColor());
        graphics2D.fillOval(getX() - getRadius(), getY() - height, diameter, height);

        int trunkWidth = diameter / 3;
        int trunkHeight = height / 2;
        int trunkX = getX() - trunkWidth / 2;
        int trunkY = getY();
        graphics2D.setColor(Color.DARK_GRAY);
        graphics2D.fillRect(trunkX, trunkY, trunkWidth, trunkHeight);
    }

    @Override
    public void move(int deltaX, int deltaY) {
        setX(getX() + deltaX);
        setY(getY() + deltaY);
    }


    @Override
    public boolean containsPoint(int x, int y) {
        int diameter = getRadius() * 2;
        int height = (int)(diameter * 1.5);

        // Check if the point is in the crown of the tree
        int ovalX = getX() - getRadius();
        int ovalY = getY() - height;
        if(new Ellipse2D.Float(ovalX, ovalY, diameter, height).contains(x, y)) {
            return true;
        }

        // Check if the point is in the trunk of the tree
        int trunkWidth = diameter / 3;
        int trunkHeight = height / 2;
        int trunkX = getX() - trunkWidth / 2;
        int trunkY = getY();
        if(new Rectangle2D.Float(trunkX, trunkY, trunkWidth, trunkHeight).contains(x, y)) {
            return true;
        }

        return false;
    }

}
