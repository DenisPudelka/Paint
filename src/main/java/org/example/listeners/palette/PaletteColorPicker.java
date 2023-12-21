package org.example.listeners.palette;

import org.example.gui.MainFrame;
import org.example.listeners.general.GeneralEventListener;
import org.example.models.layers.Layer;

import java.awt.*;
import java.awt.event.ActionEvent;

public class PaletteColorPicker extends GeneralEventListener {
    private MainFrame mainFrame;

    public PaletteColorPicker(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Layer currentLayer = mainFrame.getMainCanvas().getLayersManager().getActiveLayer();
        if(currentLayer != null){
            Color color = hexStringToColor(e.getActionCommand());
            currentLayer.setCurrentColor(color);
            mainFrame.getMenuPanel().getSouthPanel().getColorIndicator().setColorSquare(color);
        }
    }

    private Color hexStringToColor(String hex) {
        return new Color(
                Integer.valueOf(hex.substring(1, 3), 16),
                Integer.valueOf(hex.substring(3, 5), 16),
                Integer.valueOf(hex.substring(5, 7), 16)
        );
    }
}
