package org.example.models.undoredo;

import org.example.models.abstractClasses.GeometryShape;
import org.example.models.interfaces.Command;
import org.example.models.layers.CanvasMain;
import org.example.models.layers.Layer;

public class DeleteCommand implements Command {
    private GeometryShape shape;
    private Layer layer;

    public DeleteCommand( GeometryShape shape, Layer layer) {
        this.shape = shape;
        this.layer = layer;
    }

    @Override
    public void execute() {
        if(layer != null){
            layer.removeShape(shape);
        }
    }

    @Override
    public void unExecute() {
        if(layer != null){
            layer.addShape(shape);
        }
    }
}
