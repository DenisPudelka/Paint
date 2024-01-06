package org.example.listeners.layer;

import org.example.gui.MainFrame;
import org.example.listeners.general.GeneralEventListener;
import org.example.models.layers.Layer;

import java.awt.event.ActionEvent;

public class LayerCheckBox extends GeneralEventListener {

    private MainFrame mainFrame;
    private int layerId;

    public LayerCheckBox(MainFrame mainFrame, int layerId) {
        this.mainFrame = mainFrame;
        this.layerId = layerId;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Layer layer = findLayerById(layerId);
        if(layer != null && layer.isVisible()){
            layer.setVisible(false);
        }else {
            layer.setVisible(true);
        }
        mainFrame.getMainCanvas().repaint();
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
