package org.example.listeners.buttons;

import org.example.gui.MainFrame;
import org.example.listeners.general.GeneralEventListener;

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
        mainFrame.getMainCanvas().getLayersManager().addLayer();
        JList<String> layers = mainFrame.getEastPanel().getLayersPanel().getLayers();
        DefaultListModel<String> listModel = (DefaultListModel<String>) layers.getModel();
        listModel.addElement("Layer " + (listModel.getSize() + 1));
        mainFrame.getMainCanvas().getLayersManager().addLayer();
    }
}
