package org.example.listeners.combobox;

import org.example.gui.MainFrame;
import org.example.listeners.general.GeneralEventListener;
import org.example.models.enums.Shapes;
import org.example.models.layers.CanvasMain;

import javax.swing.*;
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
        CanvasMain canvas = mainFrame.getMainCanvas();
        Object shape = mainFrame.getMenuPanel().getSouthPanel().getComboBoxShapes().getSelectedItem();
        mainFrame.getMenuPanel().getSouthPanel().getLabelDrawingTool().setText("Drawing Tool: Shape " + getShapeString(shape));
        if(canvas.isBrushToolOption()){
            canvas.setBrushToolOption(false);
            mainFrame.getMenuPanel().getSouthPanel().getLabelDrawingTool().setText("Drawing Tool: Shape " + getShapeString(shape));
        }
        canvas.setCurrentShapeEnums(getShape(shape));
        canvas.setCurrentShapeEnums(getShape(shape));
    }

    private Shapes getShape(Object shape){
        if(shape instanceof ImageIcon){
            ImageIcon icon = (ImageIcon) shape;
            String description = icon.getDescription();
            switch (description){
                case "Hourglass":
                    return Shapes.HOURGLASS;
                case "Star":
                    return Shapes.STAR;
                case "House":
                    return Shapes.HOUSE;
                case "Tree":
                    return Shapes.TREE;
                case "Circle":
                    return Shapes.CIRCLE;
                case "Square":
                    return Shapes.SQUARE;
                case "Turtle":
                    return Shapes.TURTLE;
                default:
                    return Shapes.CIRCLE;
            }
        }
        return Shapes.CIRCLE;
    }

    private String getShapeString(Object shape){
        if(shape instanceof ImageIcon){
            ImageIcon icon = (ImageIcon) shape;
            String description = icon.getDescription();
            switch (description){
                case "Hourglass":
                    return "Hourglass";
                case "Star":
                    return "Star";
                case "House":
                    return "House";
                case "Tree":
                    return "Tree";
                case "Circle":
                    return "Circle";
                case "Square":
                    return "Square";
                case "Turtle":
                    return "Turtle";
                default:
                    return "Circle";
            }
        }
        return "Circle";
    }
}
