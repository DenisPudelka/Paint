package org.example.listeners.keyboard;

import org.example.gui.MainFrame;
import org.example.models.layers.Layer;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UndoKeyboardAction extends AbstractAction {
    private MainFrame mainFrame;

    public UndoKeyboardAction(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Layer activeLayer = mainFrame.getMainCanvas().getLayersManager().getActiveLayer();
        if(activeLayer != null){
            activeLayer.getManager().undo();
        }
    }
}
