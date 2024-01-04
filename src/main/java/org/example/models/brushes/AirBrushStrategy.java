package org.example.models.brushes;

import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;
import java.util.Random;

public class AirBrushStrategy implements BrushStrategy{
    private int brushSize;
    private Color color;
    private Random random;

    public AirBrushStrategy(int brushSize, Color color) {
        this.brushSize = brushSize;
        this.color = color;
        this.random = new Random();
    }

    @Override
    public void draw(Graphics2D graphics2D, Path2D path2D) {
        graphics2D.setColor(color);

        PathIterator pathIterator = path2D.getPathIterator(null);
        float[] coordinates = new float[6];

        while (!pathIterator.isDone()) {
            int type = pathIterator.currentSegment(coordinates);
            if (type != PathIterator.SEG_CLOSE) {
                int x = (int) coordinates[0];
                int y = (int) coordinates[1];
                drawSprayAroundPoint(graphics2D, x, y);
            }
            pathIterator.next();
        }
    }

    private void drawSprayAroundPoint(Graphics2D graphics2D, int x, int y) {
        int radius = brushSize * 2;
        for (int i = 0; i < brushSize * 2; i++) { // Adjust number of dots
            int dx = random.nextInt(radius) - radius / 2;
            int dy = random.nextInt(radius) - radius / 2;
            graphics2D.fillOval(x + dx, y + dy, brushSize / 8, brushSize / 8); // Adjust dot size
        }
    }
}
