package org.example.listeners.buttons;

import org.example.gui.MainFrame;
import org.example.listeners.general.GeneralEventListener;
import org.example.models.layers.CanvasMain;

import java.awt.event.ActionEvent;

public class DeleteButtonListener extends GeneralEventListener {
    private MainFrame mainFrame;

    public DeleteButtonListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CanvasMain canvas = mainFrame.getMainCanvas();
        canvas.toggleDeleteOption();
        mainFrame.getMenuPanel().getSouthPanel().getLabelOption().setText("Delete");
        if(canvas.isBrushToolOption()){
            canvas.toggleBrushOption();
        }
        if(canvas.isMoveOption()){
            canvas.toggleMoveOption();
        }
        if(!canvas.isDeleteOption()){
            mainFrame.getMenuPanel().getSouthPanel().getLabelOption().setText("...");
        }
    }

}
