package org.example.listeners.buttons;

import org.example.gui.MainFrame;
import org.example.gui.south_panel.SouthPanel;
import org.example.listeners.general.GeneralEventListener;
import org.example.models.enums.Shapes;
import org.example.models.layers.CanvasMain;

import java.awt.event.ActionEvent;

public class WatercolorBrushButtonListener extends GeneralEventListener {
    private MainFrame mainFrame;

    public WatercolorBrushButtonListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        CanvasMain canvasMain = mainFrame.getMainCanvas();
        SouthPanel southPanel = mainFrame.getMenuPanel().getSouthPanel();

        if(!canvasMain.isBrushToolOption()) {
            canvasMain.toggleBrushOption();
        }
        if (canvasMain.isBrushToolOption()){
            canvasMain.setCurrentShapeEnums(Shapes.WATERCOLOR_BRUSH);
            southPanel.getLabelDrawingTool().setText("Drawing Tool: Watercolor Brush");
            if (!canvasMain.isBrushToolOption()) {
                southPanel.getLabelDrawingTool().setText("Drawing Tool: Shape " + mainFrame.getMenuPanel().getSouthPanel().getComboBoxShapes().getSelectedItem());
            }
        }
    }
}
