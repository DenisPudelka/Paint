package org.example.listeners.layer;

import org.example.gui.MainFrame;
import org.example.listeners.general.GeneralEventListener;
import org.example.models.layers.Layer;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;

public class LayerEventLastener extends GeneralEventListener {
    private MainFrame mainFrame;
    private JList<String> layers;

    public LayerEventLastener(MainFrame mainFrame, JList<String> layers) {
        this.mainFrame = mainFrame;
        this.layers = layers;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        super.valueChanged(e);
        if (!e.getValueIsAdjusting()) {
            int selectedIndex = layers.getSelectedIndex();
            if(selectedIndex != -1){
                Layer selectedLayer = mainFrame.getMainCanvas().getLayersManager().getLayers().get(selectedIndex);
                mainFrame.getMainCanvas().getLayersManager().setActiveLayer(selectedLayer);
                mainFrame.getMainCanvas().repaint();
            }
        }
    }
}
