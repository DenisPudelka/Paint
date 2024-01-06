package org.example.listeners.buttons;

import org.example.gui.MainFrame;
import org.example.gui.east_panel.LayerPanel;
import org.example.gui.east_panel.LayersPanel;
import org.example.listeners.general.GeneralEventListener;
import org.example.models.layers.Layer;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class NewLayerJButtonListener extends GeneralEventListener {
    private MainFrame mainFrame;

    public NewLayerJButtonListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
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
