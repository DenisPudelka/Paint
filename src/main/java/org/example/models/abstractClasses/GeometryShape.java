package org.example.models.abstractClasses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public abstract class GeometryShape implements Serializable {
    private int x;
    private int y;
    private int radius;
    private Color color;

    public GeometryShape(int x, int y, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    public abstract void draw(Graphics2D graphics2D);

    public abstract void move(int deltaX, int deltaY);
    public abstract boolean containsPoint(int x, int y);

}
