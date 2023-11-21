package org.example.listeners.keyboard;

import org.example.gui.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class NewLayerKeyboardAction extends AbstractAction {
    private MainFrame mainFrame;

    public NewLayerKeyboardAction(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.getMainCanvas().getLayersManager().addLayer();
        JList<String> layers = mainFrame.getEastPanel().getLayersPanel().getLayers();
        DefaultListModel<String> listModel = (DefaultListModel<String>) layers.getModel();
        listModel.addElement("Layer " + (listModel.getSize() + 1));
        mainFrame.getMainCanvas().getLayersManager().addLayer();
    }
}
