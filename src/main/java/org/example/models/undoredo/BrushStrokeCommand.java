package org.example.models.undoredo;

import org.example.models.brushes.Brush;
import org.example.models.interfaces.Command;
import org.example.models.layers.Layer;

public class BrushStrokeCommand implements Command {
    private Layer layer;
    private Brush brush;

    public BrushStrokeCommand(Layer layer, Brush brush) {
        this.layer = layer;
        this.brush = brush;
    }

    @Override
    public void execute() {
        layer.addShape(brush);
    }

    @Override
    public void unExecute() {
        layer.removeShape(brush);
    }
}
