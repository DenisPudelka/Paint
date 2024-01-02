package org.example.listeners.keyboard;

import org.example.gui.MainFrame;
import org.example.gui.east_panel.LayerPanel;
import org.example.gui.east_panel.LayersPanel;
import org.example.models.layers.Layer;
import org.example.models.layers.LayersManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DeleteLayerKeyboardListener extends AbstractAction {
    private MainFrame mainFrame;

    public DeleteLayerKeyboardListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
/*
    @Override
    public void actionPerformed(ActionEvent e) {
        if(mainFrame.getMainCanvas().getLayersManager().getLayers().size() > 1){
            int selectIndex = mainFrame.getEastPanel().getLayersPanel().getLayers().getSelectedIndex();
            if(selectIndex != -1){
                mainFrame.getMainCanvas().getLayersManager().getLayers().remove(selectIndex);
                DefaultListModel<String> listModel = (DefaultListModel<String>) mainFrame.getEastPanel().getLayersPanel().getLayers().getModel();
                listModel.remove(selectIndex);
            }
        }
        mainFrame.getMainCanvas().repaint();
    }
*/
    @Override
    public void actionPerformed(ActionEvent e) {
        LayersManager layersManager = mainFrame.getMainCanvas().getLayersManager();
        LayersPanel layersPanel = mainFrame.getEastPanel().getLayersPanel();
        if(layersManager.getLayers().size() > 1) {
            Layer layerToRemove = mainFrame.getMainCanvas().getLayersManager().getActiveLayer();
            layersManager.removeLayer(layerToRemove);
            if (!layersManager.getLayers().isEmpty()) {
                Layer newActiveLayer = layersManager.getLayers().get(layersManager.getLayers().size() - 1);
                layersManager.setActiveLayer(newActiveLayer);
                JPanel layersContainerPanel = layersPanel.getLayersPanel();
                for (Component comp : layersContainerPanel.getComponents()) {
                    if (comp instanceof LayerPanel) {
                        LayerPanel layerPanel = (LayerPanel) comp;
                        if (layerPanel.getLayerId() == layerToRemove.getId()) {
                            layersContainerPanel.remove(layerPanel);
                            break;
                        }
                        if (layerPanel.getLayerId() == newActiveLayer.getId()) {
                            layerPanel.getLayerButton().setBackground(new Color(178, 255, 102));
                        }
                    }
                }
                layersContainerPanel.revalidate();
                layersContainerPanel.repaint();
            }
        }
        mainFrame.getMainCanvas().repaint();
    }
}
