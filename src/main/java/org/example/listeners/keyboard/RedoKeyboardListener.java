package org.example.listeners.keyboard;

import org.example.gui.MainFrame;
import org.example.models.layers.Layer;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RedoKeyboardListener extends AbstractAction {
    private MainFrame mainFrame;

    public RedoKeyboardListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Layer activeLayer = mainFrame.getMainCanvas().getLayersManager().getActiveLayer();
        if(activeLayer != null){
            activeLayer.getManager().redo();
        }
    }
}
