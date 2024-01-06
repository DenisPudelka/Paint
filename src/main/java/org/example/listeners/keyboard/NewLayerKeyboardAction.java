package org.example.listeners.keyboard;

import org.example.gui.MainFrame;
import org.example.gui.east_panel.LayerPanel;
import org.example.gui.east_panel.LayersPanel;
import org.example.models.layers.Layer;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class NewLayerKeyboardAction extends AbstractAction {
    private MainFrame mainFrame;

    public NewLayerKeyboardAction(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Layer newLayer = mainFrame.getMainCanvas().getLayersManager().addLayer();
        mainFrame.getMenuPanel().getSouthPanel().getColorIndicator().setColorSquare(newLayer.getCurrentColor());
        mainFrame.getMainCanvas().getLayersManager().setActiveLayer(newLayer);

        LayerPanel newLayerPanel = new LayerPanel(mainFrame, newLayer.getId(), newLayer.isVisible());

        LayersPanel layersPanel = mainFrame.getEastPanel().getLayersPanel();
        layersPanel.getLayersPanel().add(newLayerPanel);
        layersPanel.getLayersPanel().revalidate();
        layersPanel.getLayersPanel().repaint();
    }
}
