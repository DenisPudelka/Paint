package org.example.listeners.buttons;

import org.example.gui.MainFrame;
import org.example.listeners.general.GeneralEventListener;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RemoveLayerJButton extends GeneralEventListener {
    private MainFrame mainFrame;

    public RemoveLayerJButton(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
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
