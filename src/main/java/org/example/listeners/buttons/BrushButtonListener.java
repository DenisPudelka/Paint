package org.example.listeners.buttons;

import org.example.gui.MainFrame;
import org.example.listeners.general.GeneralEventListener;
import org.example.models.layers.CanvasMain;

import java.awt.event.ActionEvent;

public class BrushButtonListener extends GeneralEventListener {
    private MainFrame mainFrame;

    public BrushButtonListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        CanvasMain canvas = mainFrame.getMainCanvas();
        canvas.toggleBrushOption();
        mainFrame.getMenuPanel().getSouthPanel().getLabelDrawingTool().setText("Drawing Tool: Brush");
        if(!canvas.isBrushToolOption()){
            mainFrame.getMenuPanel().getSouthPanel().getLabelDrawingTool().setText("Drawing Tool: Shape " + mainFrame.getMenuPanel().getSouthPanel().getComboBoxShapes().getSelectedItem());
        }
    }
}
