package org.example.models.undoredo;

import org.example.models.abstractClasses.GeometryShape;
import org.example.models.interfaces.Command;
import org.example.models.layers.Layer;

public class DrawShapeCommand implements Command {
    private Layer targetLayer;
    private GeometryShape shape;

    public DrawShapeCommand(Layer targetLayer, GeometryShape shape) {
        this.targetLayer = targetLayer;
        this.shape = shape;
    }

    @Override
    public void execute() {
        targetLayer.addShape(shape);
    }

    @Override
    public void unExecute() {
        targetLayer.removeShape(shape);
    }
}
