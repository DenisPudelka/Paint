package org.example.models.brushes;

import java.awt.*;
import java.awt.geom.Path2D;

public interface BrushStrategy {
    void draw(Graphics2D graphics2D, Path2D path2D);
}
