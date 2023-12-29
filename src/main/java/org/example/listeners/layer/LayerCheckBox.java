package org.example.listeners.layer;

import org.example.gui.MainFrame;
import org.example.listeners.general.GeneralEventListener;

import java.awt.event.ActionEvent;

public class LayerCheckBox extends GeneralEventListener {

    private MainFrame mainFrame;

    public LayerCheckBox(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);

    }
}
