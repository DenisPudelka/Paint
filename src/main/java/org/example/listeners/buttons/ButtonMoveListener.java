package org.example.listeners.buttons;

import org.example.gui.MainFrame;
import org.example.listeners.general.GeneralEventListener;
import org.example.models.layers.CanvasMain;

import java.awt.event.ActionEvent;

public class ButtonMoveListener extends GeneralEventListener {
    private MainFrame mainFrame;

    public ButtonMoveListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        CanvasMain canvas = mainFrame.getMainCanvas();
        canvas.toggleMoveOption();
        mainFrame.getMenuPanel().getSouthPanel().getLabelOption().setText("Action: Move");
        if(canvas.isBrushToolOption()){
            canvas.toggleBrushOption();
        }
        if(canvas.isDeleteOption()){
            canvas.toggleDeleteOption();
        }
        if(!canvas.isMoveOption()){
            mainFrame.getMenuPanel().getSouthPanel().getLabelOption().setText("Action: none");
        }
    }
}
