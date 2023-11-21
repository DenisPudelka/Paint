package org.example.listeners.keyboard;

import org.example.gui.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DeleteLayerKeyboardListener extends AbstractAction {
    private MainFrame mainFrame;

    public DeleteLayerKeyboardListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

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
}
