package org.example.listeners.layer;

import org.example.gui.MainFrame;
import org.example.gui.east_panel.LayerPanel;
import org.example.listeners.general.GeneralEventListener;
import org.example.models.layers.Layer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class LayerButton extends GeneralEventListener {
    private MainFrame mainFrame;
    private int layerId;

    public LayerButton(MainFrame mainFrame, int layerId) {
        this.mainFrame = mainFrame;
        this.layerId = layerId;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object source = e.getSource();
        JPanel layersPanel = mainFrame.getEastPanel().getLayersPanel().getLayersPanel();

        for(Component comp : layersPanel.getComponents()){
            if(comp instanceof LayerPanel){
                ((LayerPanel) comp).getLayerButton().setBackground(Color.WHITE);
            }
        }

        Layer layerToActivate = findLayerById(layerId);
        if (layerToActivate != null) {
            mainFrame.getMainCanvas().getLayersManager().setActiveLayer(layerToActivate);
            if(source instanceof Component){
                ((Component)source).setBackground(new Color(178,255,102));
            }
            mainFrame.getMainCanvas().repaint();
        }
    }

    private Layer findLayerById(int id) {
        for (Layer layer : mainFrame.getMainCanvas().getLayersManager().getLayers()) {
            if (layer.getId() == id) {
                return layer;
            }
        }
        return null;
    }
}
