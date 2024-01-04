package org.example.listeners.buttons;

import org.example.gui.MainFrame;
import org.example.gui.south_panel.SouthPanel;
import org.example.listeners.general.GeneralEventListener;
import org.example.models.enums.Shapes;
import org.example.models.layers.CanvasMain;

import java.awt.event.ActionEvent;

public class AirBrushButtonListener extends GeneralEventListener {
    private MainFrame mainFrame;

    public AirBrushButtonListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        CanvasMain canvasMain = mainFrame.getMainCanvas();
        SouthPanel southPanel = mainFrame.getMenuPanel().getSouthPanel();


        if(!canvasMain.isBrushToolOption()) {
            canvasMain.toggleBrushOption();
        }else if (canvasMain.isBrushToolOption()){
            canvasMain.setCurrentShapeEnums(Shapes.AIR_BRUSH);
            southPanel.getLabelDrawingTool().setText("Drawing Tool: Air Brush");
            if (!canvasMain.isBrushToolOption()) {
                southPanel.getLabelDrawingTool().setText("Drawing Tool: Shape " + mainFrame.getMenuPanel().getSouthPanel().getComboBoxShapes().getSelectedItem());
            }
        }
    }

    private boolean isGeometryShape(Shapes shape) {
        String n = shape.toString();
        switch (n) {
            case "TREE":
                return true;
            case "HOUSE":
                return true;
            case "TURTLE":
                return true;
            case "STAR":
                return true;
            case "CIRCLE":
                return true;
            case "SQUARE":
                return true;
            case "HOURGLASS":
                return true;
            default:
                return false;
        }
    }
}
