package org.example.listeners.combobox;

import org.example.gui.MainFrame;
import org.example.listeners.general.GeneralEventListener;
import org.example.models.abstractClasses.GeometryShape;
import org.example.models.enums.Shapes;
import org.example.models.layers.Layer;

import java.awt.event.ActionEvent;

public class ComboBoxShapeListener extends GeneralEventListener {
    private MainFrame mainFrame;

    public ComboBoxShapeListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        System.out.println("Shape");
        Object shape = mainFrame.getMenuPanel().getSouthPanel().getComboBoxShapes().getSelectedItem();
        mainFrame.getMenuPanel().getSouthPanel().getLabelShape().setText(getShapeString(shape));
        mainFrame.getMainCanvas().setCurrentShapeEnums(getShape(shape));
        mainFrame.getMainCanvas().setCurrentShapeEnums(getShape(shape));
    }

    private Shapes getShape(Object shape){
        String pickedShape = ((String) shape).toUpperCase();
        switch (pickedShape){
            case "HOURGLASS":
                return Shapes.HOURGLASS;
            case "STAR":
                return Shapes.STAR;
            case "HOUSE":
                return Shapes.HOUSE;
            case "TREE":
                return Shapes.TREE;
            case "CIRCLE":
                return Shapes.CIRCLE;
            case "SQUARE":
                return Shapes.SQUARE;
            case "TURTLE":
                return Shapes.TURTLE;
            default:
                return Shapes.CIRCLE;
        }
    }

    private String getShapeString(Object shape){
        String pickedShape = ((String) shape).toUpperCase();
        switch (pickedShape){
            case "HOURGLASS":
                return "Hourglass";
            case "STAR":
                return "Star";
            case "HOUSE":
                return "House";
            case "TREE":
                return "Tree";
            case "CIRCLE":
                return "Circle";
            case "SQUARE":
                return "Square";
            case "TURTLE":
                return "Turtle";
            default:
                return "Circle";
        }
    }
}
